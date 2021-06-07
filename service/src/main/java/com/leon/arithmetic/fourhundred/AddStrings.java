package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    AddStrings
  * @Description: 415
  * @Author:      liyang
  * @Date:        2021/3/12
  * version     1.0.0
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int sum = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuffer ret = new StringBuffer();
        while (i>=0 || j>=0 || sum>=10){
            int x = i>=0 ? num1.charAt(i)-'0' : 0;
            int y = j>=0 ? num2.charAt(j)-'0' : 0;
            sum = x+y+sum/10;
            ret.append(sum%10);
            i--;
            j--;
        }
        ret.reverse();
        return ret.toString();
    }
}