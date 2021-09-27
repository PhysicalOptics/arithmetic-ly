package com.leon.arithmetic.hot100;

import java.util.HashMap;
import java.util.LinkedList;

/**
  * ClassName:    LongestValidParentheses
  * @Description: 最长有效括号32
  * @Author:      liyang
  * @Date:        2021/9/23
  * version     1.0.0
 */
public class LongestValidParentheses32 {

    // 判断各种情况的处理
    public static int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (c=='('){
                stack.push(i);
            }else if (c==')'){
                if (stack.size()==1){
                    stack.pop();
                    stack.push(i);
                }else {
                    stack.pop();
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses("(()"));
    }
}