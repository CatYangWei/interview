package com.yang.learn.multisource1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.yang.learn.multisource1.mapper")
@ComponentScan({"com.yang.learn.multisource1"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MultiSource1Application {

    public static void main(String[] args) {
        SpringApplication.run(MultiSource1Application.class, args);
    }

}
