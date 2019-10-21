package com.yang.learn.multisource1.service.impl;

import com.yang.learn.multisource1.anotions.DataSource;
import com.yang.learn.multisource1.entity.Info;
import com.yang.learn.multisource1.mapper.InfoMapper;
import com.yang.learn.multisource1.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl  implements InfoService {

    @Autowired
    InfoMapper infoMapper;

    @Override
    @DataSource(name = "source2")
    public Info getInfo() {
        return infoMapper.selectByPrimaryKey(1);
    }
}
