package br.unesp.agrotech.utils;

import br.unesp.agrotech.models.SensorMessage;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
@RabbitListener(queues = "${rabbitmq.queue}", id = "listener")
public class RabbitConsumer {
    private static Logger logger = LogManager.getLogger(RabbitConsumer.class.toString());

    @RabbitHandler
    public void consume(SensorMessage message) {
        logger.info(message.toString());
    }
}
