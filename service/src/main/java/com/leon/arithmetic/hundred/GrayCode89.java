package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
  * ClassName:    GrayCode89
  * @Description: 89. 格雷编码
  * @Author:      liyang
  * @Date:        2022/3/18
  * version     1.0.0
 */
public class GrayCode89 implements Callable {


    public static void main(String[] args){
    }
    public List<Integer> grayCode2(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        while (n-- > 0) {
            int m = ans.size();
            for (int i = m - 1; i >= 0; i--) {
                ans.set(i, ans.get(i) << 1);
                ans.add(ans.get(i) + 1);
            }
        }
        return ans;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }


    @Override
    public Object call() throws Exception {
        return null;
    }
}