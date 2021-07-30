package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
  * ClassName:    MinWindow
  * @Description: 76
  * @Author:      liyang
  * @Date:        2021/7/22
  * version     1.0.0
 */
public class MinWindow {
    public static void main(String[] args){
        MinWindow minWindow = new MinWindow();
        String s = minWindow.minWindow("","");
        System.out.println(s);
//        String substring = "abcde".substring(0, 0+4);
//        System.out.println(substring);
    }

    public String minWindow(String s, String t) {
        int left=0,right=0;
        char[] source = s.toCharArray();
        char[] tchars = t.toCharArray();
        HashMap<Character, Integer> target = new HashMap<>();
        for (char c : tchars) {
            target.put(c,target.getOrDefault(c,0)+1);
        }
        int cur = 0,start = 0,minlen = s.length()+1;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right<s.length()){
            char c = source[right];
            right++;
            if (t.indexOf(c)>-1){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).intValue()==target.get(c).intValue()){
                    cur++;
                }
            }
            while (cur==target.size()){
                if (right-left<minlen){
                    minlen = right-left;
                    start = left;
                }
                char d = source[left];
                left++;
                if (t.indexOf(d)>-1){
                    Integer temp = window.get(d);
                    if (temp.intValue()==target.get(d).intValue()){
                        cur--;
                    }
                    window.put(d,temp-1);
                }
            }
        }
        return  minlen==s.length()+1?"":s.substring(start,start+minlen);
    }
}