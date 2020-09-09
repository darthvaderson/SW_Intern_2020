package com.qcells.consumer.data.parsing.dto;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GatewayLog {
    private int gt_id;
    private long startTs;
    private long endTs;
    private String mac_fix;
    private String sn_fix;
    private String software_version_fix;
    private String ioboard_fix;
}
