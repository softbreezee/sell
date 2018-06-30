package com.softbreezee.demo.utils;

import java.util.Random;

/**
 * @author: create by leon
 * @version: v1.0
 * @description: com.softbreezee.demo.utils
 * @date:2018/6/30
 */
public class KeyUtil {
    /**
     * 生成唯一的主键，
     * 格式：时间+随机数
     * 注意：这里要同步锁，保证线程安全
     *
     * @return
     */
    public synchronized static String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);

    }
}
