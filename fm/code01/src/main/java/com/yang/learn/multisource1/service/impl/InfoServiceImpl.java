package com.yang.learn.multisource1.service.impl;

import com.yang.learn.multisource1.anotions.DataSource;
import com.yang.learn.multisource1.entity.Info;
import com.yang.learn.multisource1.mapper.InfoMapper;
import com.yang.learn.multisource1.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl  implements InfoService {

    @Autowired
    InfoMapper infoMapper;

    @Qualifier("jdbcTemplate1")
    @Autowired
    JdbcTemplate jdbcTemplate1;

    @Qualifier("jdbcTemplate2")
    @Autowired
    JdbcTemplate jdbcTemplate2;

    private static final String  SQL = "select name from info where id=?";

    @Override
    @DataSource(name = "source2")
    public Info getInfo(Integer id) {
        return infoMapper.selectByPrimaryKey(id);
    }


    @Override
    public String getInfoByTemplate1(Integer id) {
       return jdbcTemplate1.queryForObject(SQL,String.class,new Object[]{id});
    }

    @Override
    public String getInfoByTemplate2(Integer id) {
        return jdbcTemplate2.queryForObject(SQL,String.class,new Object[]{id});
    }
}
