package com.leon.arithmetic.onehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
  * ClassName:    lengthOfLongestSubstring
  * @Description: 
  * @Author:      liyang
  * @Date:        2021/2/20
  * version     1.0.0
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int left=0,r=0,length=0;
        int[] t = new  int[128];
        /*ArrayList<Character> strings = new ArrayList<>();
        while (r<s.length()){
            while (strings.contains(s.charAt(r))){
                strings.remove(0);
            }
            strings.add(s.charAt(r++));
            length = length>strings.size() ? length:strings.size();
        }
        return length;*/

        while (r<s.length()){
            left = Math.max(left, t[s.charAt(r)]);
            t[s.charAt(r)] = r+1;
            length = Math.max(length,r-left+1);
            r++;
        }
        return length;
    }

    public static void main(String[] args){
//        System.out.println("abcabcbb".substring(0,0));
        System.out.println(lengthOfLongestSubstring("abcbde"));
    }


    public int maxLength (int[] arr) {
        // write code here
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int start = 0,end= 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])){
                start = Math.max(start,map.get(arr[end])+1);
            }
            ret = Math.max(ret,end-start+1);
            map.put(arr[end],end);
        }
        return ret;

    }
}