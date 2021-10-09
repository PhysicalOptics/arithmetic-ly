package com.leon.arithmetic.fourhundred;

import java.util.HashMap;

/**
  * ClassName:    ToHex405
  * @Description: 转16进制
  * @Author:      liyang
  * @Date:        2021/10/8
  * version     1.0.0
 */
public class ToHex405 {

    public static void main(String[] args){
//        ToHex405 hex405 = new ToHex405();
//        System.out.println(hex405.toHex2(-2));
        System.out.println(0^1);
    }


    // 位运算技巧解法
    public String toHex2(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num!=0){
            int i = num & 15;
            char c = (char)(i + '0');
            if (c>'9') c = (char)(i-10+'a');
            sb.append(c);
            num = num>>>4;
        }
        return sb.reverse().toString();
    }

    // 未利用技巧纯暴力解法
    public String toHex(int num) {

        HashMap<Integer, String> transMap = new HashMap<Integer, String>() {{
            put(0, "0");
            put(1, "1");
            put(2, "2");
            put(3, "3");
            put(4, "4");
            put(5, "5");
            put(6, "6");
            put(7, "7");
            put(8, "8");
            put(9, "9");
            put(10, "a");
            put(11, "b");
            put(12, "c");
            put(13, "d");
            put(14, "e");
            put(15, "f");
        }};
        String ret ;
        boolean fu = num < 0;
        boolean jia = false;
        // 对最低位处理，负数需要取反加一
        int i = Math.abs(num % 16);
        num = num/16;
        if (fu){
            // 取反加一
            int i1 = 15 - i + 1;
            if (i1 > 15){
                jia = true;
                ret = transMap.get(0);
            }else {
                ret = transMap.get(i1);
            }
        }else {
            ret = transMap.get(i);
        }
        while (num!=0){
            int y = Math.abs(num % 16);
            if (fu){
                y= 15-y;
                if (jia) {
                    y += 1;
                    jia = false;
                }
                if (y>15){
                    y=0;
                    jia = true;
                }
            }
            String ystr = transMap.get(y);
            ret = ystr + ret;
            num=num/16;
        }
        if (fu&&ret.length()<8){
            int length = ret.length();
            for (int j = 0; j < (8 - length); j++) {
                ret = "f"+ret;
            }
        }
        return ret;
    }

}