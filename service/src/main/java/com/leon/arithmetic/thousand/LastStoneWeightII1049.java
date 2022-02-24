package com.leon.arithmetic.thousand;

/**
  * ClassName:    LastStoneWeightII1049
  * @Description: 1049. 最后一块石头重量II ，选择任意两个石头，使得最后结果最小
  * @Author:      liyang
  * @Date:        2022/2/23
  * version     1.0.0
 */
public class LastStoneWeightII1049 {


    public static void main(String[] args){
        int i = lastStoneWeightII(new int[]{31,26,33,21,40});
        System.out.println(i);
    }
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum+=stone;
        }
        int t = sum/2;
        // 对皮两半，如果能耦合住则中位置最大为能劈开的数
        int[] dp = new int[t + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = t; j >=stones[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[t];
    }

    public static boolean check(int[] stones,int target){
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >=stones[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
                if (dp[j]==target) return true;
            }
        }
        return false;
    }
}