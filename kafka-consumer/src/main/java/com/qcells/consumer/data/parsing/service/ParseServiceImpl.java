package com.qcells.consumer.data.parsing.service;

import com.google.gson.Gson;
import com.qcells.consumer.client.ConsumerService;
import com.qcells.consumer.data.model.Data;
import com.qcells.consumer.data.model.gateway.Gateway;
import com.qcells.consumer.data.model.gateway.GatewayDevice;
import com.qcells.consumer.data.model.strings.*;
import com.qcells.consumer.data.parsing.dao.DeviceDao;
import com.qcells.consumer.data.parsing.dao.GatewayLogDao;
import com.qcells.consumer.data.parsing.dao.ModulesLogDao;
import com.qcells.consumer.data.parsing.dao.StringsLogDao;
import com.qcells.consumer.data.parsing.dto.Device;
import com.qcells.consumer.data.parsing.dto.GatewayLog;
import com.qcells.consumer.data.parsing.dto.ModulesLog;
import com.qcells.consumer.data.parsing.dto.StringsLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ParseService")
public class ParseServiceImpl implements ParseService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    Gson gson;
    Data data;

    private GatewayLogDao gatewayDao;
    private StringsLogDao stringsDao;
    private ModulesLogDao modulesDao;
    private DeviceDao deviceDao;

    @Autowired
    public ParseServiceImpl(GatewayLogDao gwLog, StringsLogDao stLog, ModulesLogDao mdLog, DeviceDao dvDao) {
        this.gatewayDao = gwLog;
        this.stringsDao = stLog;
        this.modulesDao = mdLog;
        this.deviceDao = dvDao;
    }

    private Gateway gw;
    private GatewayDevice gwd;
    private GatewayLog gwLog;

    private Strings st;
    private StringDevice std;
    private StringDeviceInfo stdinfo;
    private StringsLog stLog;

    private Modules md;
    private ModuleDevice mdd;
    private ModulesLog mdLog;

    private Device dv;

    @Override
    public void parseData(String str){
        gson = new Gson();
        data = gson.fromJson(str, Data.class);

        insertGateway(str);
        insertStrings();
    }

    public void insertGateway(String str){
        gw = data.getGateway();

        for(int i=0; i<gw.getDevices().size(); ++i){
            gwd = gw.getDevices().get(i);
            gwLog = new GatewayLog(Integer.parseInt(gwd.getId()), gwd.getStartTs(), gwd.getEndTs(), gwd.getMac(), gwd.getSn(), gwd.getSoftware().getVersion(), gwd.getIoboard().getFirmware());
            if(gatewayDao.insertGateway(gwLog) == 1){
                logger.info(gw.toString());
            }

            dv = new Device(Integer.parseInt(gwd.getId()), str);
            deviceDao.updateDeviceInfo(dv);
        }

    }

    public void insertStrings(){

        st = data.getStrings();

        for(int i=0; i<st.getDevices().size(); ++i){
            std = st.getDevices().get(i);
            stdinfo = std.getInfo();
            stLog = new StringsLog(Integer.parseInt(gwd.getId()), stdinfo.getId(), st.getStartTs(), st.getEndTs(),
                    stdinfo.getPortError(), stdinfo.getHost(), stdinfo.getPort(),
                    stdinfo.getName(), stdinfo.getSerialNo(), stdinfo.getFwVersion(), stdinfo.getComparator(),
                    stdinfo.getDevider(), stdinfo.getRawPulsesCounter(), std.getError(),
                    std.getStringVoltage(), std.getStringCurrent(), std.getTemperature(), std.getTotalWh());

            stringsDao.insertStrings(stLog);

            md = std.getModules();

            insertModules();
        }
    }

    public void insertModules(){
        for(int i=0; i<md.getDevices().size(); ++i){
            mdd = md.getDevices().get(i);
            mdLog = new ModulesLog(mdd.getModuleSerial(), stdinfo.getId(), Integer.parseInt(gwd.getId()), md.getStartTs(), md.getEndTs(), mdd.getModuleVoltage(), mdd.getModuleTemperature(), mdd.getModuleWatt(), mdd.getModuleCurrent());
            modulesDao.insertModules(mdLog);
        }
    }

}
