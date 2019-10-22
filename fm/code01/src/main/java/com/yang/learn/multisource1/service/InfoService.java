package com.yang.learn.multisource1.service;

import com.yang.learn.multisource1.entity.Info;

public interface InfoService {
    Info getInfo(Integer id);

    String getInfoByTemplate1(Integer id);

    String getInfoByTemplate2(Integer id);
}
