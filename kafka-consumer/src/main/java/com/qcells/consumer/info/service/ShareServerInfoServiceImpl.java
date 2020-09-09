package com.qcells.consumer.info.service;

import com.qcells.consumer.hazelcast.manager.MapManager;
import com.qcells.consumer.info.dto.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShareServerInfoServiceImpl implements ShareServerInfoService {

	MapManager mapManager;
	ServerInfoManager serverInfoManager;

	ServerInfo serverInfo;

	@Autowired
	public ShareServerInfoServiceImpl(MapManager queueManager, ServerInfoManager serverInfoManager) {
		this.mapManager = queueManager;
		this.serverInfoManager = serverInfoManager;
	}

	public void shareServerInfo() {

		serverInfo = serverInfoManager.getServerInfo();

		if (mapManager.getServerInfoMap(serverInfo.getIpAddress()) != null) {
			//System.out.println(mapManager.getServerInfoMap(serverInfo.getIpAddress()));
			//System.out.println("data exist!");

		}

		mapManager.putServerInfoMap(serverInfo.getIpAddress(), serverInfo);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
