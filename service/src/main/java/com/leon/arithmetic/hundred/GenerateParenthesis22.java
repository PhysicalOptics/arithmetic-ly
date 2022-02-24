package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    GenerateParenthesis22
  * @Description: 22. 括号的生成
  * @Author:      liyang
  * @Date:        2021/12/23
  * version     1.0.0
 */
public class GenerateParenthesis22 {

    Character[] kuo = new Character[]{'(',')'};

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrace2(list,n,n,sb);
        return list;
    }


    public void backtrace2(List<String> list,int zuo,int you,StringBuilder sb){
        if (zuo==0&&you==0){
            list.add(sb.toString());
            return;
        }
        if (zuo==you){
            backtrace2(list,zuo-1,you,sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }else {
            if (zuo>0){
                backtrace2(list,zuo-1,you,sb.append("("));
                sb.deleteCharAt(sb.length()-1);
            }
            backtrace2(list,zuo,you-1,sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }

    }

    public void backtrace(List<String> list,int zuo,int you,StringBuilder sb,int can){
        if (zuo==0&&you==0){
            list.add(sb.toString());
            return;
        }
        if (can>0){
            if (zuo>0){
                for (int i = 0; i < 2; i++) {
                    sb.append(kuo[i]);
                    if (i==0){
                        backtrace(list,zuo-1,you,sb,can+1);
                    }else {
                        backtrace(list,zuo,you-1,sb,can-1);
                    }
                    sb.deleteCharAt(sb.length()-1);
                }
            }else {
                sb.append(")");
                backtrace(list,zuo,you-1,sb,can-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }else {
            sb.append("(");
            backtrace(list,zuo-1,you,sb,can+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}