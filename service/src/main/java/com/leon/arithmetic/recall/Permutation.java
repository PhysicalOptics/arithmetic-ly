package com.leon.arithmetic.recall;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    Permutation
  * @Description: 回溯
  * @Author:      liyang
  * @Date:        2021/2/23
  * version     1.0.0
 */
public class Permutation {
    public static String[] permutation(String S) {
        ArrayList<Character> param = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            param.add(S.charAt(i));
        }
        char[] temp = new char[S.length()];
        boolean[] booleans = new boolean[S.length()];
        for (int i = 0; i < S.length(); i++) {
            booleans[i]=false;
        }
        ArrayList<String> ret = new ArrayList<>();
        recall(ret,temp,param,0 ,booleans);
        return ret.toArray(new String[ret.size()]);
    }

    public static void recall(List<String> ret, char[] temp, ArrayList<Character> param, int index,boolean[] booleans){
        if (temp.length==index){
            ret.add(new String(temp));
            return;
        }
        for (int i = 0; i < param.size(); i++) {
            if (booleans[i]) continue;
            temp[index] = param.get(i);
            booleans[i] = true;
            recall(ret,temp,param,index+1,booleans);
            booleans[i] = false;
        }
    }

    public static void main(String[] args){
        System.out.println(permutation("abc"));
    }
}