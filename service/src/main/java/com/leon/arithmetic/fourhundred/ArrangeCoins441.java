package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    ArrangeCoins441
  * @Description: 排列硬币
  * @Author:      liyang
  * @Date:        2021/10/11
  * version     1.0.0
 */
public class ArrangeCoins441 {

    public static void main(String[] args){
        ArrangeCoins441 coins441 = new ArrangeCoins441();
        System.out.println(coins441.arrangeCoins(1804289383));
        System.out.println(coins441.arrangeCoins2(1804289383));

    }
    // 二分
    public int arrangeCoins2(int n) {
        long left= 1,right=n;
        while (left<right){
            long mid = left + (right - left+1) / 2;
            long sum = (1 + mid) * mid / 2;
            if (sum==n) return (int) mid;
            if (sum>n){
                right = mid-1;
            }else {
                left = mid;
            }
        }
        return (int) right;
    }

    public int arrangeCoins(int n) {
        int i = 1,ret = 0;
        while (n>=i){
            n = n - i;
            ret++;
            i++;
        }
        return ret;
    }
}