package com.yang.learn.multisource1.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author coffezcat
 * @title: TempleConfig
 * @description: TODO
 * @date 2019-10-22 15:20
 */
@Import(RoutingConfig.class)
@Configuration
public class TempleConfig {

    @Bean(name = "jdbcTemplate1")
    public JdbcTemplate jdbcTemplate1(@Qualifier("dataSource1")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "jdbcTemplate2")
    public JdbcTemplate jdbcTemplate2(@Qualifier("dataSource2")DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
