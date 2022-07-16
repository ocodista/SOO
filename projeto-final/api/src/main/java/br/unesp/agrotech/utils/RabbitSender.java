package br.unesp.agrotech.utils;

import br.unesp.agrotech.models.SensorMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    private static Logger logger = LogManager.getLogger(RabbitSender.class.toString());
    public void send(SensorMessage message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
        logger.info("Sending Message to the Queue : " + message.toString());
    }
}
