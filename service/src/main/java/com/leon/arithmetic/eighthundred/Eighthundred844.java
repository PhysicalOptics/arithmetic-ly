package com.leon.arithmetic.eighthundred;

/**
  * ClassName:    Eighthundred844
  * @Description: 844. 含退格的相同字符串
  * @Author:      liyang
  * @Date:        2021/12/3
  * version     1.0.0
 */
public class Eighthundred844 {

    public static void main(String[] args){
        System.out.println(backspaceCompare("ab##","ad#######"));

    }
    
    public static boolean backspaceCompare(String s, String t) {
        int si=s.length()-1,ti = t.length()-1;
        while (si>=0 || ti>=0){
            int sd = 0;
            while (si>=0&&s.charAt(si)=='#'){
                si--;
                sd++;
            }
            si -= sd;
            int td = 0;
            while (ti>=0&&t.charAt(ti)=='#'){
                ti--;
                td++;
            }
            ti -= td;
            if (si<0 && ti<0) return true;
            if (si*ti<0) return false;
            if (s.charAt(si)==t.charAt(ti)){
                si--;
                ti--;
            }else {
                return false;
            }
        }
        return true;
    }
}