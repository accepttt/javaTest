package com.example.jenkinstest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {
    @Autowired
    KafkaTemplate kafkaTemplate;
    @PostMapping("/postTest")
    public void postPic(@RequestBody String msg) throws IOException {
        kafkaTemplate.send("test_topic",msg).addCallback(new KafkaSendCallback() {
            @Override
            public void onFailure(KafkaProducerException e) {
                System.out.println("失败");
            }

            @Override
            public void onSuccess(Object o) {
                System.out.println("成功");
            }
        });
    }

    @PostMapping("/postRandom")
    public String postRandom(@RequestBody String id){
        return id;
    }


    @GetMapping("/test")
    public String test(){
        return "hello,world! hhh";
    }

}

