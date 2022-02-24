package com.leon.arithmetic.threehundred;

import java.util.HashMap;

/**
  * ClassName:    CanConstruct383
  * @Description: 383. 赎金信
  * @Author:      liyang
  * @Date:        2021/12/6
  * version     1.0.0
 */
public class CanConstruct383 {

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) cnt[c - 'a']++;
        for (char c : ransomNote.toCharArray()) if (--cnt[c - 'a'] < 0) return false;
        return true;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            targetMap.put(c,targetMap.getOrDefault(c,0)+1);
        }

        HashMap<Character, Integer> sourceMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            sourceMap.put(c,sourceMap.getOrDefault(c,0)+1);
        }

        for (Character c : targetMap.keySet()) {
            if (targetMap.getOrDefault(c,0) > sourceMap.getOrDefault(c,0)){
                return false;
            }
        }
        return true;

    }
}