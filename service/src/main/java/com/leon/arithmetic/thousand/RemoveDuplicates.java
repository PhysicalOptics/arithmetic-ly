package com.leon.arithmetic.thousand;

/**
  * ClassName:    RemoveDuplicates
  * @Description: 1047
  * @Author:      liyang
  * @Date:        2021/3/9
  * version     1.0.0
 */
public class RemoveDuplicates {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        char[] re = new char[S.length()];
        int temp=-1;
        for (int i = 0; i < S.length(); i++) {
            if (temp>=0 && re[temp]==chars[i]){
                temp--;
            }else {
                temp++;
                re[temp] = chars[i];
            }
        }
        return new String(re, 0, temp + 1);
    }

    public static void main(String[] args){
        String b = "abc".replace('b', ' ');
        System.out.println(b);
    }
}