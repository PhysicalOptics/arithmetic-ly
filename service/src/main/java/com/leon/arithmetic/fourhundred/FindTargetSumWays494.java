package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    FindTargetSumWays494
  * @Description: 494. 目标和,使用+ - 使得结果为目标；
 * 被减和为x 那么sum-x-x=target
 * 所以只要拼凑出被减x 就能得到最后的target
 * x=(sum-target)/2 如果sum小于target则直接方案为0
  * @Author:      liyang
  * @Date:        2022/2/23
  * version     1.0.0
 */
public class FindTargetSumWays494 {

    public static void main(String[] args){
        //int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        //System.out.println(targetSumWays);
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        // 如果和还小于target则没有办法，如果被减数是小数也将得不到最终的target
        if (target>sum && (sum-target)%2==1) return 0;
        //新的目标值
        int t = (sum-target)/2;
        int[] dp = new int[t + 1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = t; j >=nums[i] ; j--) {
                dp[j] = dp[j]+dp[j-nums[i]];
            }
        }
        return dp[t];
    }


    int count=0;

    public int findTargetSumWays(int[] nums, int target) {
        sumCheck(nums,0,target,0);
        return count;
    }

    public void sumCheck(int[] nums,int index,int target,int sum){
        if (index==nums.length){
            if (target==sum)count++;
        }else {
            sumCheck(nums,index+1,target,sum+nums[index]);
            sumCheck(nums,index+1,target,sum-nums[index]);
        }

    }

}