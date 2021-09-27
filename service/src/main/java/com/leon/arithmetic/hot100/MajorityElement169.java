package com.leon.arithmetic.hot100;

import java.util.HashMap;
import java.util.Map;

/**
  * ClassName:    MajorityElement
  * @Description: 多数元素169
  * @Author:      liyang
  * @Date:        2021/9/23
  * version     1.0.0
 */
public class MajorityElement169 {

    // 投票机制
    public int majorityElement2(int[] nums) {
        int condition = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count==0){
                condition = nums[i];
            }
            count += condition==nums[i]?1:-1;
        }
        return condition;
    }

    // map存储
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if (map.get(num)>nums.length/2){
                return num;
            }
        }
        return 0;
    }
}