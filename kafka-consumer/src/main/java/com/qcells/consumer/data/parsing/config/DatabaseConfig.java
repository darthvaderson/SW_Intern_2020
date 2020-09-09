package com.qcells.consumer.data.parsing.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = "com.qcells.consumer.data.parsing.dao"
)
public class DatabaseConfig { }