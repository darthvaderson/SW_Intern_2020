package com.qcells.consumer.data.parsing.dao;

import com.qcells.consumer.data.parsing.dto.ModulesLog;
import org.springframework.stereotype.Repository;

@Repository
public interface ModulesLogDao {
	public int insertModules(ModulesLog modulesLog);
}
