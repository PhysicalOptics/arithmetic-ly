package com.leon.arithmetic.hundred;

/**
  * ClassName:    CountAndSay38
  * @Description: 38、外观数列
  * @Author:      liyang
  * @Date:        2021/10/15
  * version     1.0.0
 */
public class CountAndSay38 {
    public static void main(String[] args){
        CountAndSay38 say38 = new CountAndSay38();
        String s = say38.countAndSay(4);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        String s = "1";
        while (n>1){

            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            char temp=chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (temp==chars[i]){
                    count++;
                }else {
                    sb.append(count).append(temp);
                    temp = chars[i];
                    count = 1;
                }
            }
            sb.append(count).append(temp);
            s=sb.toString();
            n--;
        }


        return s;
    }


}