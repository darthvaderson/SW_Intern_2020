package com.qcells.consumer.info.service;

import com.qcells.consumer.info.dto.ServerInfo;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service("SystemInfoService")
public class SystemInfoServiceImpl implements SystemInfoService{

    private OperatingSystemMXBean osBean;
    private InetAddress inetAddress;
    @Value("${server.port}")
    private String port;

    @PostConstruct
    public void initialize() throws UnknownHostException {
        osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        inetAddress = InetAddress.getLocalHost();
    }
    //ServerInfo에 1.서버호스트명 2. 아이피 3.CPU 사용량, 4.메모리 사용량 셋팅 해서 반환
    public ServerInfo getSystemInfo(){

        ServerInfo info = new ServerInfo();
        //set hostName and ipAddress
        info.setHostname(inetAddress.getHostName());
        info.setIpAddress(inetAddress.getHostAddress()+":"+port);

        double free_memory = (double)osBean.getFreePhysicalMemorySize();
        double total_memory = (double)osBean.getTotalPhysicalMemorySize();
        //set default cpu_usage as negative
        double cpu_usage = -1;

        //calculating memory_usage from free_memory & total_memory
        double memory_usage = Math.round(((total_memory-free_memory)/total_memory)*10000)/100.0;

        //calculating cpu_usage takes processing time.
        //setting MAX 3seconds to get a proper cpu_usage data.
        //otherwise cpu_usage returns -100, meaning failure to get current cpu_usage.
        //"timeout 500" sets interval between each trial to get cpu_usage.
        try {
            long t = System.currentTimeMillis();
            while (System.currentTimeMillis() < t + 3000) {
                cpu_usage = osBean.getSystemCpuLoad() * 10000;
                TimeUnit.MILLISECONDS.sleep(500);
                if(cpu_usage>=0) break;
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            info.setCpuUsage((Math.round(cpu_usage))/100.0);
            info.setMemUsage(memory_usage);
        }

        return info;
    }

}
