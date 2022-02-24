package com.leon.arithmetic.hundred;

/**
  * ClassName:    CanJump45
  * @Description: 45. 跳跃游戏II - 最少步数跳到终点
  * @Author:      liyang
  * @Date:        2021/12/23
  * version     1.0.0
 */
public class CanJump45 {

    public static void main(String[] args){
        int[] a = {1,1,2,1,1};
        CanJump45 canJump45 = new CanJump45();
        canJump45.jump(a);
    }

    public int jump2(int[] nums) {
        int len = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < len-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i==end){
                end = maxPosition;
                steps++;
                if (end>=len-1) return steps;
            }
        }
        return steps;
    }

    public int jump(int[] nums) {
        if (nums.length==1)return 0;
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 0;
        int r = nums[0];
        int pre = r;
        if (r>=nums.length-1) return 1;
        dp[pre] = 1;
        for (int i = 1; i < length; i++) {
            if (i<=pre){
                dp[i] = dp[pre];
                // 更新当前范围内的最新最大值
                r = Math.max(r,i+nums[i]);
            }else {
                // 超过范围，更新当前最大范围的步数，并确定最大范围pre
                dp[i] = dp[pre]+1;
                if (r>=length-1) return dp[i];
                pre = r;
                dp[pre] = dp[i];
            }
        }
        return dp[length-1];
    }
}