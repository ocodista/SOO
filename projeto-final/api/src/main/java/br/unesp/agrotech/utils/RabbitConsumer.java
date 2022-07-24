package br.unesp.agrotech.utils;

import br.unesp.agrotech.dtos.DispositivoDTO;
import br.unesp.agrotech.entities.DispositivoEntity;
import br.unesp.agrotech.models.SensorMessage;
import br.unesp.agrotech.services.locacao.v1.DispositivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Component
@RequiredArgsConstructor
@RabbitListener(queues = "${rabbitmq.queue}", id = "listener")
public class RabbitConsumer {
    private static Logger logger = LogManager.getLogger(RabbitConsumer.class.toString());
    private final SimpMessagingTemplate simpMessagingTemplate;

    private final DispositivoService dispositivoService;

    @Value("${websocket.room}")
    private String webSocketRoom;

    @Value("${websocket.channel}")
    private String webSocketChannel;


    private void broadcastUpdateToSocket(SensorMessage message) {
        String fullPath = "/" + webSocketRoom + "/" + webSocketChannel;
        simpMessagingTemplate.convertAndSend(fullPath, message);
    }

    private void persistMessageToDatabase(SensorMessage message) {
        try {
            Long id = message.getId();
            dispositivoService.atualizaValor(id, message.getValue());
        }catch (Exception e) {
            logger.error("Erro ao persistir atualização do dispositivo\n" + e);
        }

    }
    @RabbitHandler
    public void consume(SensorMessage message) {
        logger.info(message.toString());
        persistMessageToDatabase(message);
        broadcastUpdateToSocket(message);

    }
}
