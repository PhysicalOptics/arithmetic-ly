package com.leon.arithmetic.thousand;

import java.util.Arrays;

/**
  * ClassName:    MinimumTimeRequired
  * @Description: 1723
  * @Author:      liyang
  * @Date:        2021/5/8
  * version     1.0.0
 */
public class MinimumTimeRequired {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int sum = Arrays.stream(jobs).sum();
        int avg = sum/k;
        int ret=0,temp = 0;
        int left = 0,right = jobs.length-1;
        while (left<right){
            temp = jobs[right] + jobs[left];
            while (temp<avg){
                left++;
                temp+=jobs[left];
            }
        }
        for (int job : jobs) {
            temp+=job;
            if (temp>=avg){

            }
        }
        return 0;
    }
}