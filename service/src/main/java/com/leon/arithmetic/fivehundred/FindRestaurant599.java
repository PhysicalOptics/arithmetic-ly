package com.leon.arithmetic.fivehundred;

import java.util.*;

/**
  * ClassName:    FindRestaurant599
  * @Description: 599. 两个列表相同项且最小索引和
  * @Author:      liyang
  * @Date:        2022/3/14
  * version     1.0.0
 */
public class FindRestaurant599 {
    
    public String[] findRestaurant(String[] list1, String[] list2) {

        int n = list1.length, m = list2.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(list1[i], i);
        List<String> ans = new ArrayList<>();
        int min = 3000;
        for (int i = 0; i < m; i++) {
            String s = list2[i];
            if (!map.containsKey(s)) continue;
            if (i + map.get(s) < min) {
                ans.clear();
                min = i + map.get(s);
                ans.add(s);
            } else if (i + map.get(s) == min) {
                ans.add(s);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}