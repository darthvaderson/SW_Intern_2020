package com.qcells.consumer.data.parsing.dto;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModulesLog {
    private int md_sn;
    private int st_id;
    private int gt_id;
    private long startTs;
    private long endTs;
    private float moduleVoltage;
    private float moduleTemperature;
    private int moduleWatt;
    private float moduleCurrent;
}
