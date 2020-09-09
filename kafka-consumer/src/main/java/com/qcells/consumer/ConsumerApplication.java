package com.qcells.consumer;

import com.qcells.consumer.client.ConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
        ((ConsumerService)context.getBean("ConsumerService")).run();
    }
}
