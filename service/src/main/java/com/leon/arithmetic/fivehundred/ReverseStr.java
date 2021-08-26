package com.leon.arithmetic.fivehundred;

/**
  * ClassName:    ReverseStr
  * @Description: 翻转字符
  * @Author:      liyang
  * @Date:        2021/8/20
  * version     1.0.0
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int t = 0;
        while (len-t>=k){
            //翻转前k个
            for (int i = 0; i < k/2; i++) {
                char temp = chars[t+i];
                chars[t+i] = chars[t+k-i-1];
                chars[t+k-i-1] = temp;
            }
            t+=2*k;
        }
        for (int i = 0; i < (len-t)/2; i++) {
            char temp = chars[t+i];
            chars[t+i] = chars[len-i-1];
            chars[len-i-1] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args){
        ReverseStr reverseStr = new ReverseStr();
        System.out.println(reverseStr.reverseStr("abcd",4));
    }


}