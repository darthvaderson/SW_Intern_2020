package com.qcells.web.inter.config;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.qcells.consumer.info.dto.ServerInfo;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service("hazelCastConfig")
public class HazelCastConfig {

	private Config cfg;
	private HazelcastInstance instance;
	private final Integer backupCount = 1;
	
	@PostConstruct
	public void init() {
		cfg = new Config();
		cfg.setInstanceName("SharingForWebServer");

		MemberAttributeConfig mConfig = new MemberAttributeConfig();
		mConfig.setStringAttribute("service", "MLPE Data Service and Server Info");

		cfg.setMemberAttributeConfig(mConfig);
		
		setUpNetwork();
		setUpClustersByMultiCast();
		
		instance = Hazelcast.newHazelcastInstance(cfg);
	}

	public void setUpNetwork() {
		NetworkConfig network = cfg.getNetworkConfig();
		network.setPort(5900)
			   .setPortAutoIncrement(true)
			   .setPortCount(100);
	}

	public void setUpClustersByMultiCast() {
		NetworkConfig network = cfg.getNetworkConfig();
		JoinConfig join = network.getJoin();
		join.getMulticastConfig()
			.setEnabled(true)
			.setMulticastGroup("224.2.2.3")
			.setMulticastPort(54333);
	}
	
	public Config getConfig() {
		return cfg;
	}
	
	public void addMap(String mapName) {
		MapConfig mapConfig = new MapConfig();
		mapConfig.setName(mapName);
		mapConfig.setBackupCount(backupCount);		// sync backup
		instance.getConfig().addMapConfig(mapConfig);
	}

	public IMap<String, ServerInfo> getMap(String mapName) {
		return instance.getMap(mapName);
	}


}
