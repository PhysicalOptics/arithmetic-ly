package com.leon.arithmetic.twohundred;

import java.util.HashMap;
import java.util.HashSet;

/**
  * ClassName:    ContainsDuplicate
  * @Description: 217
  * @Author:      liyang
  * @Date:        2021/4/19
  * version     1.0.0
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                Integer pre = map.get(nums[i]);
                if (i-pre<=k){
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])){
//                return true;
//            }else {
//                set.add(nums[i]);
//            }
//        }
//        return false;
    }
}