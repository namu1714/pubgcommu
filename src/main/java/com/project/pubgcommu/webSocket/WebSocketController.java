package com.project.pubgcommu.webSocket;

import com.project.pubgcommu.webSocket.dto.KillLogMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("message")
    @SendTo("/topic/message")
    public KillLogMessage sendLog(@Payload KillLogMessage message){
        return message;
    }
}
