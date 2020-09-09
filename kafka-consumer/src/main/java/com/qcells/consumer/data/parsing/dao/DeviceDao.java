package com.qcells.consumer.data.parsing.dao;

import com.qcells.consumer.data.parsing.dto.Device;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceDao {
	public int updateDeviceInfo(Device device);
}
