package com.leon.arithmetic.fourhundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * ClassName:    ReadBinaryWatch
  * @Description: 401
  * @Author:      liyang
  * @Date:        2021/6/21
  * version     1.0.0
 */
public class ReadBinaryWatch {
    static Map<Integer, List<String>> map = new HashMap<>();

    static {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int total = getCnt(i) + getCnt(j);
                List<String> list = map.getOrDefault(total, new ArrayList<>());
                list.add(i+":"+(j<9?"0"+j:j));
                map.put(total,list);
            }
        }
    }

    static int getCnt(int t){
        int n = 0;
        while (t!=0){
            if ((t&1)==1)n++;
            t = t>>>1;
        }
        return n;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        return map.get(turnedOn);
    }

    public static void main(String[] args){
        ReadBinaryWatch watch = new ReadBinaryWatch();
        System.out.println(watch.readBinaryWatch(5));
    }
}