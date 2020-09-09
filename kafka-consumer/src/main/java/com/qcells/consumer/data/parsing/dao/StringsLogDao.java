package com.qcells.consumer.data.parsing.dao;

import com.qcells.consumer.data.parsing.dto.StringsLog;
import org.springframework.stereotype.Repository;

@Repository
public interface StringsLogDao {
	public int insertStrings(StringsLog stringsLog);
}
