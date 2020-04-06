package com.example.demo.produce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
    private static final String TOPIC = "users";
/*
    @Autowired
    private org.springframework.kafka.core.KafkaTemplate<String,String> KafkaTemplate;


    public void send(String payload) {
        LOGGER.info("sending payload: " + payload);
        this.KafkaTemplate.send(TOPIC, payload);
    }*/
}
