package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.models.SensorMessage;
import br.unesp.agrotech.utils.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitSenderResource {
    @Autowired
    RabbitSender rabbitMQSender;
    @PostMapping(value = "/sender")
    public String producer(@RequestBody SensorMessage menuOrder) {
        rabbitMQSender.send(menuOrder);
        return "Message sent to the RabbitMQ Queue Successfully";
    }
}
