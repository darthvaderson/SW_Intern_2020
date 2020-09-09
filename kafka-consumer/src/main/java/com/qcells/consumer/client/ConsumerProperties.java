package com.qcells.consumer.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

@PropertySource("classpath:application.properties")
@Service("ConsumerProperties")
public class ConsumerProperties {

    Properties configs;
    String Topic;
    @Value("${server.port}")
    String instanceID;

    @PostConstruct
    public void initialize(){
        configs = new Properties();
        //broker 서버
        configs.put("bootstrap.servers", "http://localhost:9092");

        //그룹아이디 : 컨슈머 그룹 아이디 설정
        configs.put("group.id", "mlpe_data_group");

        //인스턴스아이디 : 컨슈머 인스턴스 아이디 설정
        configs.put("group.instance.id", instanceID);
        //key & value deserializer 설정
        configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer" );
        configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        configs.put("enable.auto.commit", false);
        //configs.put("max.poll.records", 50);

        //Consumer가 구독할 Topic 설정
        Topic = "data";
    }

}
