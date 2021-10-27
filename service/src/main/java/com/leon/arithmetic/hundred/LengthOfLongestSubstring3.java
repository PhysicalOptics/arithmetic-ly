package com.leon.arithmetic.hundred;

import java.util.HashMap;

/**
  * ClassName:    LengthOfLongestSubstring3
  * @Description: 最长子串
  * @Author:      liyang
  * @Date:        2021/10/19
  * version     1.0.0
 */
public class LengthOfLongestSubstring3 {
    public static void main(String[] args){
        LengthOfLongestSubstring3 substring3 = new LengthOfLongestSubstring3();
        substring3.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0,len = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right<s.length()){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            right++;
            while (window.get(c)>1){
                char c2 = s.charAt(left);
                window.put(c2,window.get(c2)-1);
                left++;
            }
            len =Math.max(len,right-left);
        }
        return len;
    }
}