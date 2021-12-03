package com.leon.arithmetic.sevenhundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * ClassName:    LetterCasePermutation784
  * @Description: 784. 字母转换全排列
  * @Author:      liyang
  * @Date:        2021/11/12
  * version     1.0.0
 */
public class LetterCasePermutation784 {

    Map<Character,Character> cmap = new HashMap<Character,Character>(){{
        put('a','A');
        put('a','A');
        put('a','A');
        put('a','A');
        put('a','A');
        put('a','A');
        put('a','A');
    }};

    public List<String> letterCasePermutation(String s) {
        // 1.找出所有的字母[]
        // 2.是否改变进行排列组合dfs深度字母的长度，fori 2
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: s.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                // 如果是字母,遍历所有的ans,ans翻倍
                for (int i = 0; i < n; ++i) {
                    // 取出ans的字符缓存，复制一个缓存temp2，当前追加小写的c，temp2追加大写的
                    StringBuilder temp = ans.get(i);
                    StringBuilder tempUp = new StringBuilder(temp);
                    temp.append(Character.toLowerCase(c));
                    ans.add(tempUp.append(Character.toUpperCase(c)));
                }
            } else {// 如果不是字母直接在所有ans上追加
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }

    public void dfs(ArrayList<String> list,StringBuffer sb,int length){
        if (sb.length()==length){
            list.add(sb.toString());
        }
        for (int i = 0; i < 2; i++) {

        }
    }

}