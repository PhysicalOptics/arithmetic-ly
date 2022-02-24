package com.leon.arithmetic.hundred;


import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    LetterCombinations17
  * @Description: 17. 电话号码的字母组合
  * @Author:      liyang
  * @Date:        2021/12/23
  * version     1.0.0
 */
public class LetterCombinations17 {

    String[] num = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args){
        LetterCombinations17 letterCombinations17 = new LetterCombinations17();
        List<String> strings = letterCombinations17.letterCombinations("23");
        System.out.println(JSONUtil.toJsonStr(strings));
    }

    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();
        if (digits.length()==0) return strings;
        StringBuffer sb = new StringBuffer();
        backtrace(strings,digits,0,sb);
        return strings;
    }

    public void backtrace(List<String> strings, String digits,int i,StringBuffer sb){
        if (i==digits.length()){
            strings.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        String s = num[c - '2'];
        for (int j = 0; j <s.length(); j++) {
            char c1 = s.charAt(j);
            sb.append(c1);
            backtrace(strings,digits,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}