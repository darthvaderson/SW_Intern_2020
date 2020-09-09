package com.qcells.consumer.info.service;

import com.google.gson.Gson;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@ToString
@Service("DeviceCountService")
public class DeviceCountServiceImpl implements DeviceCountService{

    private int deviceCount;
    private Gson gson = new Gson();
    private List<String> deviceList = new ArrayList<>();

    public int getCount(){
        return deviceCount;
    }
    public void upCount(){
        deviceCount++;
    }
    public void resetCount(){
        deviceCount = 0;
    }
    public List<String> getList(){return deviceList;}
    public void addList(String gateway_id){
        deviceList.add(gateway_id);
    }
    public void resetList(){
        deviceList.clear();
    }
    public Gson getGson(){return gson;}
    public void reset(){
        resetCount();
        resetList();
    }

}
