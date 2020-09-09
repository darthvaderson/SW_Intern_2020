package com.example.mlpe_producer.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

@Service("ProduceService")
@PropertySource("application.properties")
public class ProduceServiceImpl implements ProduceService{

    private static final String BROKER_URI = "localhost:9092";
    private static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
    private static final String KEY_SERIALIZER = "key.serializer";
    private static final String VALUE_SERIALIZER = "value.serializer";
    private static final String STRING_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";
    private static final String TOPIC = "data";

    private KafkaProducer<String, String> producer;
    private Properties configs;

    @PostConstruct
    private void initialize(){

        //Kafka Producer config 정의
        //key는 토픽의 파티선이 지정될 때 사용
        configs = new Properties();

        //1.bootstrap server : local의 카프카 브로커 주소
        configs.put(BOOTSTRAP_SERVERS, BROKER_URI);

        //2.Key와 Value에 대해 직렬화
        configs.put(KEY_SERIALIZER, STRING_SERIALIZER);
        configs.put(VALUE_SERIALIZER, STRING_SERIALIZER);

        producer = new KafkaProducer<String, String>(configs);

    }

    public void sendData(String st) throws IOException {
        //<Topic, Value>
        ProducerRecord record = new ProducerRecord<String, String>(TOPIC, st);
        producer.send(record);
    }
    public void close(){
        producer.close();
    }
}
