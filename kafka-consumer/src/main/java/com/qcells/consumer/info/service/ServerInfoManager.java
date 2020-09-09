package com.qcells.consumer.info.service;

import com.qcells.consumer.info.dto.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("serverInfoManager")
public class ServerInfoManager {


    DeviceCountService deviceCountService;
    SystemInfoService systemInfoService;

    @Autowired
    ServerInfoManager(DeviceCountService deviceCountService, SystemInfoService systemInfoService){
        this.deviceCountService = deviceCountService;
        this.systemInfoService = systemInfoService;
    }


    public ServerInfo getServerInfo(){

        ServerInfo serverInfo = systemInfoService.getSystemInfo();
        serverInfo.setDeviceCount(deviceCountService.getCount());
        serverInfo.setDeviceList(deviceCountService.getList());

        return serverInfo;
    }
}
