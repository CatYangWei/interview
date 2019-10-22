package com.yang.learn.multisource1.config;


import com.yang.learn.multisource1.component.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RoutingConfig {

    @Autowired
    Source1Config source1Config;

    @Autowired
    Source2Config source2Config;

    @Bean
    @Primary
    public DataSource dataSource() {
        DynamicDataSource resolver = new DynamicDataSource();
        Map<Object, Object> dataSources = new HashMap<>();
        dataSources.put("source1", dataSource1());
        dataSources.put("source2", dataSource2());
        resolver.setTargetDataSources(dataSources);
        return resolver;
    }
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix="spring.datasource.source1")
    public DataSource dataSource1() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource= new  org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUrl(source1Config.getUrl());
        dataSource.setUsername(source1Config.getUserName());
        dataSource.setPassword(source1Config.getPassword());
        dataSource.setDriverClassName(source1Config.getDriverClassName());
        return dataSource;
    }
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix="spring.datasource.source2")
    public DataSource dataSource2() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource= new  org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUrl(source2Config.getUrl());
        dataSource.setUsername(source2Config.getUserName());
        dataSource.setPassword(source2Config.getPassword());
        dataSource.setDriverClassName(source2Config.getDriverClassName());
        return dataSource;
    }
}
