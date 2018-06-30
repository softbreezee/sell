package com.softbreezee.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {

    private final Logger logger = LoggerFactory.getLogger(LogTest.class);
    @Test
    public void test(){
        String name = "eric";
        String psd = "123";
        logger.debug("...debug");
        logger.info("..info");
        logger.info("name:{},password:{}",name,psd);//{}表示占位符
        logger.error("...error");

    }

}
