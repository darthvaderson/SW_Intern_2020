package com.qcells.consumer.info.service;

import com.google.gson.Gson;

import java.util.List;

public interface DeviceCountService {
    int getCount();
    void upCount();
    void resetCount();
    List<String> getList();
    void addList(String gateway_id);
    void resetList();
    Gson getGson();
    void reset();
}
