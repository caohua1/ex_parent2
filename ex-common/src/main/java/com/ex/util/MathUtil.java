package com.ex.util;

import java.util.Random;

/**
 * @ProjectName ex_parent
 * @ClassName MathUtil
 * @Description TODO 随机数生成器
 * @Author sanmu
 * @Date 2018/6/6 17:02
 * @Version 1.0
 **/
public class MathUtil {

    /**
     * @Description TODO 传入生成随机数的长度 返回相应长度的随机数
     * @param len 长度
     * @return
     */
    public static String getRandom(int len) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                int temp = random.nextInt(10);
                if (temp != 0) {
                    result = temp + "";
                } else {
                    result = "1";
                }
            } else {
                result += random.nextInt(10);
            }
        }
        int num = Integer.parseInt(result);
        return num + "";
    }

    /**
     * @Description TODO 传入生成随机数的长度 返回相应长度的随机数
     * @param len 长度
     * @return
     */
    public static String getRandomOfStr(int len) {
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
