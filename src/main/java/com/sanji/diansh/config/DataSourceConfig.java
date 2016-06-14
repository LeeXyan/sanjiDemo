/*package com.sanji.diansh.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

*//**
 * Created by barton on 16-1-29.
 * 1.使用阿里的druid作为datasource
 *//*
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "datasource.url")
    public DataSource primary() {
        return new DruidDataSource();
    }
}*/