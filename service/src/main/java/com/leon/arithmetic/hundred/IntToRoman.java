package com.leon.arithmetic.hundred;

import java.util.HashMap;

/**
  * ClassName:    IntToRoman
  * @Description: 12
  * @Author:      liyang
  * @Date:        2021/5/14
  * version     1.0.0
 */
public class IntToRoman {

    private int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num){
        String r = "";
        for (int i = 0; i < 13; i++) {
            int value = nums[i];
            String roman = romans[i];
            while (num>=value){
                num-=value;
                r+=roman;
            }
        }
        return r;
    }

    public static void main(String[] args){
        IntToRoman intToRoman = new IntToRoman();
        String s = intToRoman.intToRoman(234);
        System.out.println(s);
    }
}