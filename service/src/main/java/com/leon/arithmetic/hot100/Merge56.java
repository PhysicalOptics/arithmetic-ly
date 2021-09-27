package com.leon.arithmetic.hot100;

import java.util.ArrayList;
import java.util.Arrays;

/**
  * ClassName:    Merge56
  * @Description: 56合并区间
  * @Author:      liyang
  * @Date:        2021/9/26
  * version     1.0.0
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int min = intervals[0][0];
        int max = intervals[0][1];
        ArrayList<int[]> retlist = new ArrayList<>();
        retlist.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            for (int[] temp : retlist) {

                if (intervals[i][0]>max){
                    retlist.add(intervals[i]);
                    max = intervals[i][1];
                }else if (intervals[i][0]<min){
                    int[] ints = retlist.get(retlist.size() - 1);
                    ints[0] = intervals[i][0];
                    min = ints[i];
                    if (intervals[i][1]>max){
                        ints[1] = intervals[i][1];
                        max = ints[1];
                    }
                }else {
                    int[] ints = retlist.get(retlist.size() - 1);
                    if (intervals[i][1]>ints[1]){
                        ints[1] = intervals[i][1];
                        max = ints[i];
                    }
                }
            }
        }
        int[][] ret = new int[retlist.size()][2];
        return retlist.toArray(ret);
    }
}