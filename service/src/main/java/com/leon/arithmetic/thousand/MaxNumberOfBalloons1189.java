package com.leon.arithmetic.thousand;

import java.util.HashMap;

/**
  * ClassName:    MaxNumberOfBalloons1189
  * @Description: 1189. 返回最大数量气球 balloon
  * @Author:      liyang
  * @Date:        2022/2/14
  * version     1.0.0
 */
public class MaxNumberOfBalloons1189 {

    public int maxNumberOfBalloons(String text) {
        int[] cnts = new int[5];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'b') cnts[0]++;
            else if (c == 'a') cnts[1]++;
            else if (c == 'l') cnts[2]++;
            else if (c == 'o') cnts[3]++;
            else if (c == 'n') cnts[4]++;
        }
        cnts[2] /= 2; cnts[3] /= 2;
        int ans = cnts[0];
        for (int i = 0; i < 5; i++) ans = Math.min(ans, cnts[i]);
        return ans;
    }
}