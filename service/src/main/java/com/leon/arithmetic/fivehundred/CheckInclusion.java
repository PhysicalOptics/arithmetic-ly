package com.leon.arithmetic.fivehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * ClassName:    CheckInclusion
  * @Description: 567
  * @Author:      liyang
  * @Date:        2021/7/23
  * version     1.0.0
 */
public class CheckInclusion {
    public static void main(String[] args){
        CheckInclusion checkInclusion = new CheckInclusion();
        checkInclusion.tribonacci(5);
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            target.put(s1.charAt(i),target.getOrDefault(s1.charAt(i),0)+1);
        }
        Map<Character, Integer> curMap = new HashMap<>();
        int left = 0,right=0,count=0;
        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;
            if (s1.indexOf(c)>-1){
                curMap.put(c,curMap.getOrDefault(c,0)+1);
                if (curMap.get(c).intValue()==target.get(c).intValue()){
                    count++;
                }
            }
            while (count==target.size()){
                if (s1.length()==right-left ) return true;
                char d = s2.charAt(left);
                left++;
                if (s1.indexOf(d)>-1){
                    if (curMap.get(d).intValue()==target.get(d).intValue()){
                        count--;
                    }
                    curMap.put(d,curMap.get(d)-1);
                }

            }
        }
        return false;
    }

    public List<Integer> checkInclusion2(String s, String p) {
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            target.put(p.charAt(i),target.getOrDefault(p.charAt(i),0)+1);
        }
        Map<Character, Integer> curMap = new HashMap<>();
        int left = 0,right=0,count=0;
        List<Integer> list = new ArrayList<>();
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if (p.indexOf(c)>-1){
                curMap.put(c,curMap.getOrDefault(c,0)+1);
                if (curMap.get(c).intValue()==target.get(c).intValue()){
                    count++;
                }
            }
            while (count==target.size()){
                if (p.length()==right-left ) list.add(left);
                char d = s.charAt(left);
                left++;
                if (p.indexOf(d)>-1){
                    if (curMap.get(d).intValue()==target.get(d).intValue()){
                        count--;
                    }
                    curMap.put(d,curMap.get(d)-1);
                }

            }
        }
        return list;
    }


    public int tribonacci(int n) {
        if(n<2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i<n+1;i++){
            dp[n] = dp[n-1]+dp[n-2]+dp[n-3];
        }
        return dp[n];
    }
}