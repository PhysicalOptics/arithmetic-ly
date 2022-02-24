package com.leon.arithmetic.thousand;

/**
  * ClassName:    TruncateSentence1816
  * @Description: 1816. 截断句子
  * @Author:      liyang
  * @Date:        2021/12/6
  * version     1.0.0
 */
public class TruncateSentence1816 {

    public static void main(String[] args){
        String s= "ni hao";
        System.out.println(s.charAt(2)==' ');
    }

    public String truncateSentence(String s, int k) {
        int length = s.length();
        int i = 0;
        while (i<length&&k>0){
            if (s.charAt(i)==' '){
                k--;
            }
            i++;
        }
        return s.substring(0,i).trim();
    }
}