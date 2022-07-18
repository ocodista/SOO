package br.unesp.agrotech.utils;

import br.unesp.agrotech.models.SensorMessage;
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

    @Value("${websocket.room}")
    private String webSocketRoom;

    @Value("${websocket.channel}")
    private String webSocketChannel;


    private void broadcastUpdateToSocket(SensorMessage message) {
        String fullPath = "/" + webSocketRoom + "/" + webSocketChannel;
        simpMessagingTemplate.convertAndSend(fullPath, message);
    }

    private void persistMessageToDatabase(SensorMessage message) {
        //TODO: Persist on database
    }
    @RabbitHandler
    public void consume(SensorMessage message) {
        logger.info(message.toString());
        persistMessageToDatabase(message);
        broadcastUpdateToSocket(message);

    }
}
