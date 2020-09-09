package com.qcells.consumer.client;

import org.apache.kafka.clients.consumer.CommitFailedException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.Arrays;


@Service("ConsumerService")
public class ConsumerService {

    private ConsumerManager consumerManager;
    private DataServiceRegister dataServiceRegister;

    @Value("${server.port}")
    private String serverport;

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    ConsumerService(ConsumerManager consumerManager, DataServiceRegister dataServiceManager){
        this.consumerManager = consumerManager;
        this.dataServiceRegister = dataServiceManager;
    }

    public void run(){

        KafkaConsumer<String, String> consumer = consumerManager.getConsumer();
        consumer.subscribe(Arrays.asList("data"));

        int cnt = 0;

            while (true) {

                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10));

                if(records.count() != 0) {
                    logger.info(serverport + "서버의 " + (++cnt) + "번째 poll: " + records.count());
                }

                for (ConsumerRecord<String, String> record : records) {

                    try{
                        if(process(record)){
                            consumer.commitSync();
                        }else{
                            consumer.seek(new TopicPartition(record.topic(), record.partition()), record.offset());
                        }
                    }catch (CommitFailedException e){
                        logger.error("Error: ", e);
                    }
                    ;
                }
            }

    }

    public boolean process(ConsumerRecord<String, String> record){
        try{
            dataServiceRegister.execute(record.value());
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
