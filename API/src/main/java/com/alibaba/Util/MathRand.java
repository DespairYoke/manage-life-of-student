package com.alibaba.Util;

import java.util.Random;

/**
 * @author zwd
 * @date 2018/3/7 08:25
 */
public class MathRand {
    public static String getCode() {
        String code = "";
        Random random = new Random();
        for (int i=0;i<6;i++) {
            code +=random.nextInt(10);
        }
        return code;
    }
}
