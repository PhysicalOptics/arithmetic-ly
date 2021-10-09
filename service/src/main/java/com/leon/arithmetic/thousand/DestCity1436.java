package com.leon.arithmetic.thousand;

import java.util.HashMap;
import java.util.List;

/**
  * ClassName:    DestCity1436
  * @Description: 1436. 旅行的终点
  * @Author:      liyang
  * @Date:        2021/10/8
  * version     1.0.0
 */
public class DestCity1436 {

    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0),path.get(1));
        }
        for (List<String> path : paths) {
            if (!map.containsKey(path.get(1))) return path.get(1);
        }
        return "";
    }


}