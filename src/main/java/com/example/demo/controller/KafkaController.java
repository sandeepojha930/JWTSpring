package com.example.demo.controller;

import com.example.demo.produce.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
  /*  private final Sender sender;
    @Autowired
    KafkaController(Sender sender){
        this.sender = sender;
    }
    @PostMapping(value = "/publish")
    public void sendMsgToKafka(@RequestParam("message") String message){
    this.sender.send(message);
    }*/
}
