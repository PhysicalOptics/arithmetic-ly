package com.leon.arithmetic.onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
  * ClassName:    LongestPalindrome
  * @Description: 5 131 132
  * @Author:      liyang
  * @Date:        2021/3/8
  * version     1.0.0
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(left + 1, right);
    }


    /*public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }*/

    //法1
//    public static String longestPalindrome(String s) {
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//        String ans = "";
//        for (int l = 0; l < n; ++l) {
//            for (int i = 0; i + l < n; ++i) {
//                int j = i + l;
//                if (l == 0) {
//                    dp[i][j] = true;
//                } else if (l == 1) {
//                    dp[i][j] = (s.charAt(i) == s.charAt(j));
//                } else {
//                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
//                }
//                if (dp[i][j] && l + 1 > ans.length()) {
//                    ans = s.substring(i, i + l + 1);
//                }
//            }
//        }
//        return ans;
//    }

    public int partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i+l < n; i++) {
                int j = i+l;
                if (l==0){
                    dp[i][j]=true;
                }else if (l==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else {
                    dp[i][j]=(s.charAt(i)==s.charAt(j))&&dp[i+1][j-1];
                }
            }
        }
//        ArrayList<List<String>> lists = new ArrayList<>();
//        backtrack(lists,new ArrayList<String>(),dp,0,n,s);
//        int min = 0;
//        for (int i = 0; i < lists.size(); i++) {
//            min = min>lists.get(i).size()?lists.get(i).size():min;
//        }
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                min[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j][i]) {
                    min[i] = Math.min(min[i],min[j]+1);
                }
            }
        }

        return min[n-1];
    }

    public void backtrack(ArrayList<List<String>> lists,List<String> list,boolean[][] dp, int index,int len,String s){
        if(index == len){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < len; i++){
            if(dp[index][i]){
                list.add(s.substring(index, i + 1 ));
                backtrack(lists,list,dp,i + 1,len,s);
                list.remove(list.size() - 1);
            }
        }
    }

    public void backtrackmin(int r ,boolean[][] dp, int index,int len,int min){
        // 如果能达到最后一个index则满足条件，copy填充list
        if(index == len){
            r=r>min?min:r;
        }
        for (int i = index; i < len; i++) {
            if(dp[index][i]) {
                min++;
                backtrackmin(r, dp, i + 1, len, min);
                min--;
            }
        }
    }


    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        char[] charArray = s.toCharArray();
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && ((right-left <= 2) || isPalindrome[left+1][right-1])) {
                    isPalindrome[left][right] = true;
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j+1][i]) {
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        LongestPalindrome test = new LongestPalindrome();
        test.minCut("aaabaa");
    }
}