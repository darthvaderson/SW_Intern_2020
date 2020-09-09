package com.qcells.web.model.dto;

import com.qcells.consumer.info.dto.ServerInfo;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UpdateInfo {

    String count;
    ArrayList<ServerInfo> info;

}
