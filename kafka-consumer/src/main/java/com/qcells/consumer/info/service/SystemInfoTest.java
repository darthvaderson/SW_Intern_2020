package com.qcells.consumer.info.service;


import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;


public class SystemInfoTest {


    public static void main(String[] args){


        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        InetAddress ip;

        //System.out.println("Memory Free Space : " + String.format("%.2f", (double)osBean.getFreePhysicalMemorySize()/1024/1024/1024  ));
        //System.out.println("Memory Total Space : " + String.format("%.2f", (double)osBean.getTotalPhysicalMemorySize()/1024/1024/1024  ));
        double free_memory = (double)osBean.getFreePhysicalMemorySize();
        double total_memory = (double)osBean.getTotalPhysicalMemorySize();
        double cpu_usage = -1;
       // System.out.println("Memory Usage : " + Math.round(((total_memory-free_memory)/total_memory)*10000)/100.0);

        try{
            ip = InetAddress.getLocalHost();
           // System.out.println(ip.getHostName());
           // System.out.println(ip.getHostAddress());
        } catch(Exception e){
            e.printStackTrace();
        }

        try {
            while (true) {
                cpu_usage = osBean.getSystemCpuLoad()*100;
                TimeUnit.MILLISECONDS.sleep(500);
                if(cpu_usage>=0) break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        // System.out.println("CPU Usage : " + String.format("%.2f", cpu_usage));

    }
}
