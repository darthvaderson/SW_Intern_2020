package com.qcells.consumer.client;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service("ConsumerManager")
public class ConsumerManager {

    ConsumerProperties properties;
    private KafkaConsumer<String, String> consumer;

    @Autowired
    ConsumerManager(ConsumerProperties properties){
        this.properties = properties;
    }

    @PostConstruct
    private void initialize(){
        consumer = new KafkaConsumer<String, String>(properties.configs);
    }

    public KafkaConsumer<String, String> getConsumer(){
        return consumer;
    }

}
