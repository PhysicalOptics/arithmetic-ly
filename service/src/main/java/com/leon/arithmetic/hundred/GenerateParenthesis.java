package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.List;

/**
  * ClassName:    GenerateParenthesis
  * @Description: 22
  * @Author:      liyang
  * @Date:        2021/5/13
  * version     1.0.0
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generate(ret,"",n,n);
        return ret;
    }

    private void generate(List<String> ret,String s, int left,int right){
        if (left==0&&right==0){
            ret.add(s);
            return;
        }
        if (left==right){
            int l = left-1;
            generate(ret,s+"(",l,right);
        }else{
            if (left>0){
                int l = left-1;
                generate(ret,s+"(",l,right);
            }
            int r = right-1;
            generate(ret,s+")",left,r);
        }
    }

    public static void main(String[] args){
        GenerateParenthesis ge = new GenerateParenthesis();
        ge.generateParenthesis(3);
    }
}