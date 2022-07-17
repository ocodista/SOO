package br.unesp.agrotech.utils;

import br.unesp.agrotech.models.SensorMessage;
import lombok.RequiredArgsConstructor;
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

    @RabbitHandler
    public void consume(SensorMessage message) {
        logger.info(message.toString());

        simpMessagingTemplate.convertAndSend("/chatroom/public", message);
    }
}
