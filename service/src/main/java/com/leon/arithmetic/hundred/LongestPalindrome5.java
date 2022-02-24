package com.leon.arithmetic.hundred;

/**
  * ClassName:    LongestPalindrome5
  * @Description: 5. 最长回文子串
  * @Author:      liyang
  * @Date:        2021/12/24
  * version     1.0.0
 */
public class LongestPalindrome5 {

    public static void main(String[] args){
        LongestPalindrome5 palindrome5 = new LongestPalindrome5();
        palindrome5.longestPalindrome("babad");
    }
    public String longestPalindrome(String s) {
        if (s.length()<2) return s;
        int len = s.length();
        String ret=s.substring(0,1);
        for (int i = 0; i < len-1; i++) {
            String huiWen1 = isHuiWen(s, i,i);
            String huiWen2 = isHuiWen(s, i,i+1);

            String huiwen = huiWen1.length() > huiWen2.length() ? huiWen1 : huiWen2;
            ret = huiwen.length()>ret.length()?huiwen:ret;

        }
        return ret;
    }

    public String isHuiWen(String s,int left,int right){
        while (left>=0&&right<=s.length()-1){
            if (s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left+1,right);
    }
}