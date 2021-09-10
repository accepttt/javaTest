package com.example.jenkinstest.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "test_topic",groupId = "test")
    public void testListener(ConsumerRecord record){
        System.out.println(record.value());
    }
}
