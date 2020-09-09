package com.qcells.web.model.service;

import com.qcells.web.inter.manager.MapManager;
import com.qcells.consumer.info.dto.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerInfoServiceImpl implements ServerInfoService {

	@Autowired
	MapManager mapManager;

	@Override
	public ServerInfo getServerInfo(String keyId) {
		// TODO Auto-generated method stub


		return mapManager.getInfoMapData(keyId);
	}
}
