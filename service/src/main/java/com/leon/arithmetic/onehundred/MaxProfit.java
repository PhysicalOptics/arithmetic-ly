package com.leon.arithmetic.onehundred;

/**
  * ClassName:    MaxProfit
  * @Description: 123
  * @Author:      liyang
  * @Date:        2021/3/16
  * version     1.0.0
 */
public class MaxProfit {


    public int maxProfit(int k, int[] prices) {

        int length = prices.length;
        if (k>length/2) return maxProfitAll(prices);
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        for (int i = 1; i <= k; i++) {
            buy[i]= -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <=k; j++) {
                // 第几次交易，这次买了就不能卖，所以卖只能取已经买了的
                // 和已经确定交易数还不一样
                int t = buy[j];
                buy[j] = Math.max(buy[j],sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j],t+prices[i]);
            }
        }
        return sell[k];
        //        if(prices.length==0) return 0;
//        int[] buy = new int[k+1];
//        int[] sell = new int[k+1];
//        for (int i = 1; i <=k ; i++) {
//            buy[i] = -prices[0];
//        }
//        for (int i = 1; i <prices.length ; i++) {
//            for (int j = 1; j <=k ; j++) {
//                int t = buy[j];
//                buy[j] = Math.max(buy[j],sell[j-1]-prices[i]);
//                sell[j] = Math.max(sell[j],t+prices[i]);
//            }
//        }
//        return sell[k];
    }

    public int maxProfitAll(int[] prices) {
        int length = prices.length;
        int ret=0;
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff>0){
                ret += diff;
            }
        }
        return ret;
    }

}