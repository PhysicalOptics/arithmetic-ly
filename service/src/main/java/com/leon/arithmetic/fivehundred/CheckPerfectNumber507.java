package com.leon.arithmetic.fivehundred;

/**
  * ClassName:    CheckPerfectNumber507
  * @Description: 507
  * @Author:      liyang
  * @Date:        2021/12/31
  * version     1.0.0
 */
public class CheckPerfectNumber507 {

    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i < num; i++) {
            if (num%i==0) sum+=i;
        }
        return sum==num;
    }

    public static void main(String[] args){
        String s = "123456789";
        System.out.println(s.substring(0,s.length()));
    }
}