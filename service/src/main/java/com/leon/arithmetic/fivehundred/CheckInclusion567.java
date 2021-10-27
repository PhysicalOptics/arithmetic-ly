package com.leon.arithmetic.fivehundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
  * ClassName:    CheckInclusion567
  * @Description: 567. 判断是否包含子串的排列
  * @Author:      liyang
  * @Date:        2021/10/19
  * version     1.0.0
 */
public class CheckInclusion567 {

    public static void main(String[] args){
        CheckInclusion567 inclusion567 = new CheckInclusion567();
        boolean b = inclusion567.checkInclusion2("abb", "eidbabooo");
        System.out.println(b);
    }

    public boolean checkInclusion2(String s1, String s2) {
        int left = 0,right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int count= 0;
        while (right<s2.length()){
            char c = s2.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            count++;
            right++;

            while (count >= s1.length()){
                char c2 = s2.charAt(left);
                for (Character character : map.keySet()) {
                    if (map.getOrDefault(character,0).intValue()!=window.getOrDefault(character,0).intValue()){
                        window.put(c2,window.get(c2)-1);
                        left++;
                        count--;
                        break;
                    }
                }
                if (count==s1.length()) return true;

            }

        }
        return false;
    }
    public boolean checkInclusion(String s1, String s2) {
        int left = 0,right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int count= 0;
        while (right<s2.length()){
            char c = s2.charAt(right);
            if (s1.indexOf(c)>-1){
                window.put(c,window.getOrDefault(c,0)+1);
                if (map.get(c).intValue()==window.get(c).intValue()){
                    count++;
                }
            }
            right++;
            while (count == map.size()){
                if (s1.length()==right-left) return true;
                char c2 = s2.charAt(left);
                left++;
                if (s1.indexOf(c2)>-1){
                    if (window.get(c2).intValue()==map.get(c2).intValue())count--;
                    window.put(c2,window.get(c2)-1);
                }
            }

        }
        return false;
    }
}