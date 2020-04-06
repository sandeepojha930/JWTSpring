package com.example.demo.consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consume {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consume.class);
   /* @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message){
        LOGGER.info("Consume message:: "+message);
    }*/

}
