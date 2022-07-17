package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.models.SensorMessage;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = { "Chat" })
@RequestMapping("/chat")
@RequiredArgsConstructor
@RestController
public class ChatResource {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public SensorMessage receiveMessage(@Payload SensorMessage message){
        return message;
    }

    @MessageMapping("/test-message")
    public void testMessage(SensorMessage message) {
        simpMessagingTemplate.convertAndSend("/chatroom/public", message);
    }
}
