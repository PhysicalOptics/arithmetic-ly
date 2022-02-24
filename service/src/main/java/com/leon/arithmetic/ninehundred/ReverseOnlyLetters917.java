package com.leon.arithmetic.ninehundred;

/**
  * ClassName:    ReverseOnlyLetters917
  * @Description: 917。 仅仅翻转字母
  * @Author:      liyang
  * @Date:        2022/2/23
  * version     1.0.0
 */
public class ReverseOnlyLetters917 {

    public static void main(String[] args){
        System.out.println(reverseOnlyLetters("ab-cd"));
    }
    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left=0,right = s.length()-1;
        while (left<right){
            while (left<right&&!Character.isLetter(chars[left]))left++;
            while (left<right&&!Character.isLetter(chars[right]))right--;
            if (left<right){
                char a = chars[left];
                chars[left] = chars[right];
                chars[right] = a;
            }
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}