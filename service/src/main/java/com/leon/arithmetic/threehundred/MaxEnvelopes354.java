package com.leon.arithmetic.threehundred;

import cn.hutool.json.JSONUtil;
import groovy.util.logging.Log;
import groovy.util.logging.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
  * ClassName:    MaxEnvelopes354
  * @Description: 354. 信封问题，俄罗斯套娃
  * @Author:      liyang
  * @Date:        2022/1/19
  * version     1.0.0
 */
public class MaxEnvelopes354 {

    public static void main(String[] args){
        //[[4,5],[4,6],[6,7],[2,3],[1,1]]
        //[[4,5],[4,6],[6,7],[2,3],[1,1]]
        //[[2,3]，[5,4],[6,4],[6,7]]
        //[[3,4],[12,2],[12,15],[30,50]]
        int[][] ints = {{4,5}, {4,6}, {6,7}, {2,3}, {1,1}};
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[0]==t2[0]){
                    return t1[1]-t1[1];
                }else {
                    return t1[0]-t2[0];
                }
            }
        });
        MaxEnvelopes354 envelopes354 = new MaxEnvelopes354();
        int i = envelopes354.maxEnvelopes(ints);
        System.out.println(i);
        System.out.println(JSONUtil.toJsonStr(ints));

    }

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a,b)->a[0]-b[0]);
        int[] tails = new int[envelopes.length];
        int max = 1;
        for (int i = 0; i < envelopes.length; i++) {
            tails[i] = 1;
            for (int j = i-1; j >=0 ; j--) {
                if (check(envelopes,j,i)){
                    tails[i] = Math.max(tails[i],tails[j]+1);
                }
            }
            Math.max(max,tails[i]);
        }
        return max;
    }

    public boolean check(int[][] envelopes,int less,int curr){
        return envelopes[curr][0]>envelopes[less][0]&&envelopes[curr][1]>envelopes[less][1];
    }

    public int maxEnvelopeslose1(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[0]==t2[0]){
                    return t2[1]-t1[1];
                }else {
                    return t1[0]-t2[0];
                }
            }
        });
        int[] tails = new int[envelopes.length];
        tails[0] = envelopes[0][1];
        int res = 0;
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1]>tails[res]){
                res++;
                tails[res] = envelopes[i][1];
            }else {
                int left = 0,right = res;
                while (left<right){
                    int mid = left+(right-left)/2;
                    if (tails[mid]<envelopes[i][1]){
                        left = mid+1;
                    }else {
                        right = mid;
                    }
                }
                tails[left] = envelopes[i][1];
            }
        }
        return res+1;
    }

}