package com.qcells.consumer.data.parsing.dto;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StringsLog {
    private int gt_id;
    private int st_id;
    private long startTs;
    private long endTs;
    private String postError;
    private String host_fix;
    private int port_fix;
    private String name_fix;
    private int serialNo_fix;
    private String fwVersion_fix;
    private int comparator_fix;
    private int devider_fix;
    private int rawPulsesCounter_fix;
    private String error;
    private int stringVoltage;
    private float stringCurrent;
    private int temperature;
    private int totalWatt;
}
