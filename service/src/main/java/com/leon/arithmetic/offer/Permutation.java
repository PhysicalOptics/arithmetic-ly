package com.leon.arithmetic.offer;

import java.util.HashSet;
import java.util.Set;

/**
  * ClassName:    Permutation
  * @Description: 38
  * @Author:      liyang
  * @Date:        2021/6/22
  * version     1.0.0
 */
public class Permutation {
    public String[] permutation(String s) {
        Set<String> ret = new HashSet<>();
        backtrack(s.toCharArray(),"",ret,new boolean[s.length()]);
        return ret.toArray(new String[ret.size()]);
    }

    private void backtrack(char[] s,String temp, Set ret,boolean[] choice){
        if (temp.length()==s.length){
            ret.add(temp);
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (choice[i]) continue;
            choice[i] = true;
            backtrack(s,temp+s[i],ret,choice);
            choice[i] = false;
        }
    }

    public static void main(String[] args){
        boolean[] booleans = new boolean[3];
        for (int i = 0; i < booleans.length; i++) {
            System.out.println(booleans[i]);
        }
    }
}