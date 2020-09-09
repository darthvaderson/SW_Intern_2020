package com.example.mlpe_producer.controller;

import com.example.mlpe_producer.service.CountService;
import com.example.mlpe_producer.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/data")
public class MLPEProducer {

    private final ProduceService produceService;
    private final CountService countService;

    @Autowired
    public MLPEProducer(ProduceService produceService, CountService countService){
        this.produceService = produceService;
        this.countService = countService;
    }

    @PostMapping
    public ResponseEntity<String> produceData(@RequestBody String st){

        try {
            produceService.sendData(st);
            countService.upCount();
            System.out.println("Produce SUCCESS");
            return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
        }

        System.out.println("Produce FAILED");
        return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
    }
}
