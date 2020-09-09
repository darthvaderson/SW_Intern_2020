package com.example.mlpe_producer.controller;


import com.example.mlpe_producer.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/count")
public class DeviceCounter {

    private final CountService countService;

    @Autowired
    DeviceCounter(CountService countService) {
        this.countService = countService;
    }

    @GetMapping
    public ResponseEntity<Integer> deliverCount(){

        int deviceCount = countService.getCount();
        countService.resetCount();

        return new ResponseEntity<Integer>(deviceCount, HttpStatus.OK);
    }

}
