package com.leon.arithmetic.sixhundred;

import java.util.HashMap;
import java.util.HashSet;

/**
  * ClassName:    JudgeSquareSum
  * @Description: 633
  * @Author:      liyang
  * @Date:        2021/4/28
  * version     1.0.0
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        if (c<3){
            return true;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (c-i*i>=0){
            if (c-i*i==0|| c==i*i*2) return true;
            if (map.containsKey(c-i*i)) return true;
            map.put(i*i,i);
            i++;
        }
        return false;

    }
}