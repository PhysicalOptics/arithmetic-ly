package com.leon.arithmetic.hundred;

import java.util.Arrays;

/**
  * ClassName:    StrStr
  * @Description: 28
  * @Author:      liyang
  * @Date:        2021/4/20
  * version     1.0.0
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if ("".equalsIgnoreCase(needle)) return 0;
        char[] hayChars = haystack.toCharArray();
        char[] needChars = needle.toCharArray();

        int i = 0;
        while (i+needChars.length<=hayChars.length){
            int j = 0,pre=i;
            while (j<needChars.length && hayChars[pre]==needChars[j]){
                pre++;
                j++;
            }
            if (j == needChars.length){
                return pre-needChars.length;
            }
            i++;
        }
        return -1;


    }

    // KMP算法，构建pmt数组关键前后缀相同
    public int strStrKMP(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        pi[0] = 0;
        // 构建pmt数组
        for (int i = 0,j=1; j < m ; j++) {
            while (i > 0 && needle.charAt(j)!=needle.charAt(i)){
                i=pi[i-1];
            }
            if (needle.charAt(i)==needle.charAt(j)){
                i++;
            }
            pi[j] = i;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String a =" 您好，您发票修改后的开票信息为：\n订单号：d21099150358184726\n发票类型：企业\n发票抬头：汕尾职业技术学院\n发票税号：12441500456909319d\n电子邮箱地址：843320567@qq.com\n请确认以上信息是否正确 ".toUpperCase();
        System.out.println(a);
    }
}