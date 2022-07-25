package br.unesp.agrotech.utils;

import br.unesp.agrotech.dtos.DispositivoDTO;
import br.unesp.agrotech.dtos.GetDispositivoDTO;
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
    private static Logger logger = LogManager.getLogger(RabbitSender.class.toString());
    public void adicionaDispositivo(String queue, GetDispositivoDTO dispositivoDTO) {
        rabbitTemplate.convertAndSend(queue, dispositivoDTO);
        logger.info("Sending Message to the Queue : " + dispositivoDTO.toString());
    }
}
