package com.example.mlpe_producer.service;


import org.springframework.stereotype.Service;

@Service("CountService")
public class CountServiceImpl implements CountService {

    int deviceCount;

    public int getCount(){
        return deviceCount;
    }
    public void upCount(){
        deviceCount++;
    }
    public void resetCount(){
        deviceCount = 0;
    }
}
