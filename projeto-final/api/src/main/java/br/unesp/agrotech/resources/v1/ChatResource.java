package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.models.SensorMessage;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${websocket.room}")
    private String webSocketRoom;

    @Value("${websocket.channel}")
    private String webSocketChannel;
    private final SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/test-message")
    public void testMessage(SensorMessage message) {
        String fullPath = "/" + webSocketRoom + "/" + webSocketChannel;
        simpMessagingTemplate.convertAndSend(fullPath, message);
    }
}
