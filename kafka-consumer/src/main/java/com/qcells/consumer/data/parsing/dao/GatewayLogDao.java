package com.qcells.consumer.data.parsing.dao;

import com.qcells.consumer.data.parsing.dto.GatewayLog;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayLogDao {
	public int insertGateway(GatewayLog gatewayLog);
}
