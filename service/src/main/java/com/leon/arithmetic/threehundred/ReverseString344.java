package com.leon.arithmetic.threehundred;

/**
  * ClassName:    Threehundred344
  * @Description: 344. 反转字符串
  * @Author:      liyang
  * @Date:        2021/10/18
  * version     1.0.0
 */
public class ReverseString344 {
    public static void main(String[] args){
        ReverseString344 reverseString344 = new ReverseString344();
        //reverseString344.reverseString(new char[]{'h','e','l','l','o'});
        reverseString344.reverseWords("Let's take LeetCode contest");
        System.out.println(
                "s'teL ekat edoCteeL tsetnoc ");
    }
    
    public void reverseString(char[] s) {
        int a= 0,b=s.length-1;
        while (a<b){
            char c = s[a];
            s[a]=s[b];
            s[b]=c;
            a++;
            b--;
        }
    }

    // 557反转字符串中单词
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String s1 : split) {
            char[] chars = s1.toCharArray();
            reverseString(chars);
            String s2 = new String(chars);
            sb.append(s2);
            if (s1!=split[split.length-1]){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}