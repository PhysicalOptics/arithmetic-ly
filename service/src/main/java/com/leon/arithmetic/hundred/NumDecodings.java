package com.leon.arithmetic.hundred;

/**
  * ClassName:    NumDecodings
  * @Description: 91
  * @Author:      liyang
  * @Date:        2021/3/30
  * version     1.0.0
 */
public class NumDecodings {
    public static int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int length = s.length();
        int[] dp = new int[length];
        dp[0] = 1;
        for(int i = 1; i < length; i++){
            char curr = s.charAt(i);
            char pre = s.charAt(i - 1);
            if(curr == '0'){
                //出现0，但是0前面不是1，2，不能解码
                if(pre != '1' && pre != '2') return 0;
                //0出现再位置1，只有一种解码方式，出现在其他位置等于dp[i-2]
                dp[i] = i == 1 ? 1 : dp[i-2];
            } else if(pre == '1' || (pre == '2' && curr -'0' > 0 && curr -'0' < 7)){
                //出现两种解法方式的条件
                //出现在位置1，没有i-2
                //出现在其他位置dp[i-1]+dp[i-2]
                dp[i] = i == 1 ? dp[i-1]+1 : dp[i-1]+dp[i-2];
            }else{
                //只有一种解码的时候
                dp[i] = dp[i-1];
            }
        }
        return dp[length -1];



//        if (s.startsWith("0"))return 0;
//        int length = s.length();
//        if(length<2) return 1;
//        int[] dp = new int[length];
//        dp[0] = 1;dp[1]=2;
//        char i0 = s.charAt(0);
//        char i1 = s.charAt(1);
//        if (i1=='0'){
//            dp[1] = 1;
//        } else if (i0=='1'||(i0=='2'&& i1 <'7')){
//            dp[1] = 2;
//        } else{
//            dp[1] = 1;
//        }
//        for (int i = 2; i < length; i++) {
//            char c = s.charAt(i-1);
//            char curr = s.charAt(i);
//            if (curr=='0'){
//                dp[i] = dp[i-1];
//            } else if (c=='1'||(c=='2'&& curr <'7')){
//                dp[i] = dp[i-2]+dp[i-1];
//            } else{
//                dp[i] = dp[i-1];
//            }
//        }
//        return dp[length-1];
    }

    public static void main(String[] args){
        numDecodings("2101");
    }
}