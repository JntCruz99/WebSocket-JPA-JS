package com.websocket.websocket;

import com.websocket.websocket.config.ObjMsg;
import com.websocket.websocket.repository.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping
public class App {

    @Autowired
    private MsgRepository msgRepository;

    @MessageMapping("/chatMessage")
    @SendTo("/canal")
    public List<ObjMsg> sendMessage(){

        return msgRepository.findAll();
    }

}