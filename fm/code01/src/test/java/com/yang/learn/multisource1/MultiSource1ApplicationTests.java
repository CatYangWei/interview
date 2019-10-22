package com.yang.learn.multisource1;

import com.yang.learn.multisource1.entity.Info;
import com.yang.learn.multisource1.service.InfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MultiSource1ApplicationTests {
    @Autowired
    InfoService infoService;
    @Test
    void contextLoads() {
         Info info = infoService.getInfo(1);
         String info1 = infoService.getInfoByTemplate1(1);
         String info2 = infoService.getInfoByTemplate2(1);
        System.out.println(1111);
    }

}
