package com.leon.arithmetic.thousand;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * ClassName:    CountMaxOrSubsets2044
  * @Description: 2044. 按位与得到最大值的子集个数
  * @Author:      liyang
  * @Date:        2022/3/15
  * version     1.0.0
 */
public class CountMaxOrSubsets2044 {



    public int countMaxOrSubsets2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put((1<<i),i);
        }
        int n = nums.length;
        // 数组有mask个子集
        int mask = 1<<n;
        // 能达到最大的结果集数
        int ans=0;
        // 子集的最大结果
        int max=0;
        int[] f = new int[mask];
        //开始枚举
        for (int i = 1; i < mask; i++) {
            // 得到为1 的最低位
            int lowbit = i & (-i);
            // 得到去除i的最低位，此时的f值
            int pre=i-lowbit,idx = map.get(lowbit);
            // f与上为1的num
            f[i] = f[pre]|nums[idx];
            if (f[i]>max){
                max=f[i];
                ans=1;
            }else if (f[i]==max){
                ans++;
            }
        }
        return ans;
    }

    // 枚举
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        // 数组有mask个子集
        int mask = 1<<n;
        // 能达到最大的结果集数
        int ans=0;
        // 子集的最大结果
        int max=0;
        //开始枚举
        for (int i = 0; i < mask; i++) {
            int cur=0;
            for (int j = 0; j < n; j++) {
                // 循环找子集，如果位置为1则有该索引上的数
                if (((i>>j)&1)==1){
                    cur |= nums[j];
                }
            }
            // 取得结果与max比较如果比max大则重置max和ans
            if (cur>max){
                max=cur;
                ans=1;
            }else if (cur==max){
                ans++;
            }
        }
        return ans;
    }


    int ans = 0,max = 0;
    public int countMaxOrSubsets3(int[] nums) {
        dfs(nums,0,0);
        return ans;
    }

    public void dfs(int[] nums,int n,int val){
        if (n==nums.length){
            if (val>max){
                max = val;
                ans = 1;
            }else if (val==max){
                ans++;
            }
            return;
        }
        dfs(nums,n+1,val);
        dfs(nums,n+1,val|nums[n]);
    }
}