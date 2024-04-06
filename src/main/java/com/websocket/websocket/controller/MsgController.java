package com.websocket.websocket.controller;

import com.websocket.websocket.config.ObjMsg;
import com.websocket.websocket.repository.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MsgController {

    @Autowired
    private MsgRepository msgRepository;

    @GetMapping
    public List<ObjMsg> getObjMsgAll(){
        return msgRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ObjMsg> getById(@PathVariable Long id){
        return msgRepository.findById(id);
    }

    @PostMapping
    public ObjMsg postObjMsg(@RequestBody ObjMsg objMsg){
        return msgRepository.save(objMsg);

    }

    @PutMapping("/{id}")
    public ObjMsg putObjMsg(@PathVariable Long id, @RequestBody ObjMsg objMsgAtualizado){
        Optional<ObjMsg> objMsOptional = msgRepository.findById(id);
        ObjMsg objMExistente = objMsOptional.get();

        objMExistente.setMsg(objMsgAtualizado.getMsg());
        objMExistente.setUsername(objMsgAtualizado.getUsername());

        return msgRepository.save(objMExistente);
    }

    @DeleteMapping("/{id}")
    public void objMsDelete(@PathVariable Long id){
        Optional<ObjMsg> objMsOptional = msgRepository.findById(id);

        msgRepository.delete(objMsOptional.get());

    }

}
