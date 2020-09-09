package com.qcells.consumer.client;


import com.google.gson.Gson;
import com.qcells.consumer.data.model.Data;
import com.qcells.consumer.data.parsing.service.ParseService;
import com.qcells.consumer.data.sharing.ShareMLPEDataService;
import com.qcells.consumer.info.service.DeviceCountService;
import com.qcells.consumer.info.service.ShareServerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("DataServiceRegister")
public class DataServiceRegister {

    private ParseService parseService;
    private DeviceCountService deviceCountService;
    private ShareServerInfoService shareServerInfoService;
    private ShareMLPEDataService shareMLPEDataService;

    @Autowired
    public DataServiceRegister(ParseService parseService, DeviceCountService deviceCountService, ShareServerInfoService shareService, ShareMLPEDataService shareMLPEDataService) {
        this.parseService = parseService;
        this.deviceCountService = deviceCountService;
        this.shareServerInfoService = shareService;
        this.shareMLPEDataService = shareMLPEDataService;
    }
//
//    @Autowired
//    public DataServiceRegister(ParseService parseService, DeviceCountService deviceCountService) {
//        this.parseService = parseService;
//        this.deviceCountService = deviceCountService;
//    }
    public void execute(String st){
//        parsing(st);
        counting(st);
        sharing(st);
    }

//    public void parsing(String st){
//        parseService.parseData(st);
//    }

    public void counting(String st){
        deviceCountService.upCount();
        deviceCountService.addList(deviceCountService.getGson().fromJson(st, Data.class).getGateway().getDevices().get(0).getId());
    }

    public void sharing(String st){
        shareServerInfoService.shareServerInfo();
        shareMLPEDataService.shareMLPEData(new Gson().fromJson(st, Data.class).getGateway().getDevices().get(0).getId(), st);
    }

}
