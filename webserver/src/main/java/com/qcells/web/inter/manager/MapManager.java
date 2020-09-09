package com.qcells.web.inter.manager;

import com.hazelcast.core.IMap;
import com.qcells.web.inter.config.HazelCastConfig;
import com.qcells.consumer.info.dto.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("queueManager")
public class MapManager {

	@Autowired
	HazelCastConfig hazelCastConfig;


	private IMap<String, ServerInfo> infoMap;

	@PostConstruct
	public void init() {
		hazelCastConfig.addMap("infoMap");

		this.infoMap = hazelCastConfig.getMap("infoMap");

		HazelcastListenerManager hazelListener = new HazelcastListenerManager();
		infoMap.addEntryListener(hazelListener, true);

	}




	public ServerInfo getInfoMapData(String keyId) {
		return infoMap.get(keyId);
	}


}
