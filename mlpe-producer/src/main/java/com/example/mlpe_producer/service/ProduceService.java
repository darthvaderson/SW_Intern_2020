package com.example.mlpe_producer.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;



public interface ProduceService {
    public void sendData(String st) throws IOException;
    public void close();
}
