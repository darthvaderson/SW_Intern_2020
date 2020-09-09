package com.qcells.consumer.data.model;


import com.qcells.consumer.data.model.inverter.Inverter;
import com.qcells.consumer.data.model.strings.Strings;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private com.qcells.consumer.data.model.gateway.Gateway Gateway;
    private Inverter Inverters;
    private Strings Strings;
}