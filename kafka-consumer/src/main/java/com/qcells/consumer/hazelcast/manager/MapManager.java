package com.qcells.consumer.hazelcast.manager;

import com.hazelcast.core.IMap;
import com.qcells.consumer.hazelcast.config.HazelCastConfig;
import com.qcells.consumer.info.dto.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import javax.annotation.PostConstruct;

@Service("mapManager")
public class MapManager {

	@Autowired
	HazelCastConfig hazelCastConfig;
	private IMap<String, Object> dataMap;
	private IMap<String, ServerInfo> infoMap;

	@PostConstruct
	public void init() {
		hazelCastConfig.addMap("dataMap");
		hazelCastConfig.addMap("infoMap");

		this.dataMap = hazelCastConfig.getMap("dataMap");
		this.infoMap = hazelCastConfig.getInfoMap("infoMap");

		HazelcastListenerManagerImpl hazelListener = new HazelcastListenerManagerImpl();
		dataMap.addEntryListener(hazelListener, true);
	}

	public void putServerInfoMap(String keyId, ServerInfo serverInfo) {
		infoMap.put(keyId, serverInfo);
	}

	public void putMLPEDataMap(String keyId, Object data) {
		dataMap.put(keyId, data);
	}

	public ServerInfo getServerInfoMap(String keyId) {
		return infoMap.get(keyId);
	}

	public Object getMLPEDataMap(String keyId) {
		return dataMap.get(keyId);
	}

}
