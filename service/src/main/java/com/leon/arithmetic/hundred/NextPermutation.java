package com.leon.arithmetic.hundred;

/**
  * ClassName:    NextPermutation
  * @Description: 31
  * @Author:      liyang
  * @Date:        2021/5/14
  * version     1.0.0
 */
public class NextPermutation {
    public void nextPermutation(int[] nums){
        int length = nums.length;
        int c = length -1;
        while (c>0){
            if (nums[c]>nums[c-1]){
                int i = c+1;
                while (i<=length-1){
                    if (nums[c-1]>=nums[i]) break;
                    i++;
                }
                swap(nums,i-1,c-1);
                break;
            }
            c--;
        }
        int end = length-1;
        while (c<end){
            swap(nums,c,end);
            c++;
            end--;
        }

    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1,5,1});
    }
}