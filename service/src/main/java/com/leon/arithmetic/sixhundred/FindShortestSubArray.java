package com.leon.arithmetic.sixhundred;

import java.util.*;

/**
  * ClassName:    FindShortestSubArray
  * @Description: 697
  * @Author:      liyang
  * @Date:        2021/2/20
  * version     1.0.0
 */
public class FindShortestSubArray {
    public static int findShortestSubArray(int[] nums) {
        int len = nums.length, maxCount = 0, minWindow = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] pair = map.get(nums[i]);
            if (pair == null) {
                pair = new int[]{i, 1};
                map.put(nums[i], pair);
            } else {
                pair[1]++;
            }
            if (pair[1] > maxCount) {
                maxCount = pair[1];
                minWindow = i - pair[0] + 1;
            } else if (pair[1] == maxCount) {
                minWindow = Math.min(minWindow, i - pair[0] + 1);
            }
        }
        return minWindow;


        /*Map<Integer,List<Integer>> dumap = new HashMap();
        int du = 0,dulength=nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (dumap.containsKey(nums[i])){
                List<Integer> idxlist = dumap.get(nums[i]);
                idxlist.add(i);
                du = du>idxlist.size()?du:idxlist.size();
            }else {
                List<Integer> idxlist = new ArrayList<>();
                idxlist.add(i);
                dumap.put(nums[i],idxlist);
                du =1;
            }
        }
        for (Integer integer : dumap.keySet()) {
            List<Integer> idxlist = dumap.get(integer);
            if (idxlist.size()==du){
                dulength = dulength> idxlist.get(idxlist.size()-1)-idxlist.get(0)+1 ? idxlist.get(idxlist.size()-1)-idxlist.get(0)+1:dulength;
            }
        }
        return dulength;*/
    }

    public static void main(String[] args){
        int[] ints = {1, 2};
        System.out.println(findShortestSubArray(ints));

    }
}