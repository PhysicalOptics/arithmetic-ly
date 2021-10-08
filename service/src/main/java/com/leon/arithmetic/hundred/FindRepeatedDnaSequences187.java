package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * ClassName:    FindRepeatedDnaSequences187
  * @Description: 重复的DNA序列
  * @Author:      liyang
  * @Date:        2021/10/8
  * version     1.0.0
 */
public class FindRepeatedDnaSequences187 {

    public static void main(String[] args){
        FindRepeatedDnaSequences187 find = new FindRepeatedDnaSequences187();
        find.findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }

    public static Map<Character,Integer> bin = new HashMap<Character,Integer>(){{
        put('A',0);
        put('T',1);
        put('C',2);
        put('G',3);
    }};

    public List<String> findRepeatedDnaSequences2(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s.length()<10) return list;
        HashMap<Integer, Integer> map = new HashMap<>();
        int t = 0;
        for (int i = 0; i < 9; i++) {
            t = t<<2 | bin.get(s.charAt(i));
        }
        for (int i = 9; i < s.length(); i++) {
            t = ((t<<2) | bin.get(s.charAt(i))) & ((1<<20)-1);
            map.put(t,map.getOrDefault(t,0)+1);
            if (map.get(t)==2){
                list.add(s.substring(i-10+1,i+1));
            }
        }
        return list;
    }


    // 法一
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s.length()<10) return list;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            String substring = s.substring(i - 10, i);
            map.put(substring,map.getOrDefault(substring, 0)+1);
            if (map.get(substring) == 2) {
                list.add(substring);
            }
        }
        return list;
    }

}