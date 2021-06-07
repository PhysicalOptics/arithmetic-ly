package com.leon.arithmetic.math;

import java.util.HashMap;

/**
  * ClassName:    RomaNumTest
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/1/13
  * version     1.0.0
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 */
public class RomaNumTest {


    public static int romanToInt(String s) {

        int sum = getValue(s.charAt(0));
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            if (pre< value){
                sum -= 2*pre;
            }
            pre = value;
            sum += value;
        }
        /*
        if (s.contains("I")&&(s.contains("V")||s.contains("X"))){
            if (s.indexOf("I")<s.lastIndexOf("V")||s.indexOf("I")<s.lastIndexOf("X")){
                String remin = s.replaceAll("I", "");
                sum -= (s.length()-remin.length())*2;
            }
        }
        if (s.contains("X")&&(s.contains("L")||s.contains("C"))){
            if (s.indexOf("X")<s.lastIndexOf("L")||s.indexOf("X")<s.lastIndexOf("C")){
                int i = s.lastIndexOf("XL") > s.lastIndexOf("XC") ? s.lastIndexOf("XL") : s.lastIndexOf("XC");
                String substring = s.substring(0, i + 1);
                String remin = substring.replaceAll("X", "");
                sum -= (substring.length()-remin.length())*20;
            }
        }
        if (s.contains("C")&&(s.contains("D")||s.contains("M"))){
            if (s.indexOf("C")<s.lastIndexOf("D")||s.indexOf("C")<s.lastIndexOf("M")){
                int i = s.lastIndexOf("CM") > s.lastIndexOf("CD") ? s.lastIndexOf("CM") : s.lastIndexOf("CD");
                String substring = s.substring(0, i + 1);
                String remin = substring.replaceAll("C", "");
                sum -= (substring.length()-remin.length())*200;
            }
        }*/

        return sum;
    }

    public static int getValue(char c){
        switch (c){
            case 'I' :return 1;
            case 'V' :return 5;
            case 'X' :return 10;
            case 'L' :return 50;
            case 'C' :return 100;
            case 'D' :return 500;
            case 'M' :return 1000;
            default:return 0;
        }
    }

    public static void main(String[] args){
        String s = "MCMXCIV";
//        System.out.println(s.substring(s.length()-3));
        System.out.println(romanToInt(s));
    }
}