package com.leon.arithmetic.eighthundred;

/**
  * ClassName:    Transpose
  * @Description: 867
  * @Author:      liyang
  * @Date:        2021/2/25
  * version     1.0.0
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引
 * 输入：matrix = [[1,2,3],
 *                [4,5,6],
 *                [7,8,9]]
 * 输出：[[1,4,7],
 *       [2,5,8],
 *       [3,6,9]]
 */


public class Transpose {
    public int[][] transpose(int[][] matrix) {
        int[][] ret = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }

    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;  //[)
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {         //   if (canTrans(weights,mid,days)){
                left = mid + 1;                //       right = mid;
            } else if (nums[mid] < target) {   //   }else {
                left = mid + 1;                //       left = mid+1;
            } else if (nums[mid] > target) {   //   }
                right = mid;                   //
            }
        }
        return left - 1; // 注意                //return left;
    }
}