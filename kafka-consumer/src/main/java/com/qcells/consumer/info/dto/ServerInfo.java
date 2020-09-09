package com.qcells.consumer.info.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerInfo implements Serializable {

    String ipAddress;
    String hostname;
    double cpuUsage;
    double memUsage;
    int deviceCount;
    List<String> deviceList;

}
