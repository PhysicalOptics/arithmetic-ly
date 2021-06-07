package com.leon.arithmetic.threehundred;

/**
  * ClassName:    IsValidSerialization
  * @Description: 331
  * @Author:      liyang
  * @Date:        2021/3/12
  * version     1.0.0
 */
public class IsValidSerialization {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;

//        if (preorder == "#"){
//            return true;
//        }
//        String[] split = preorder.split(",");
//        int in=0,out=0;
//        for (int i = 0; i < split.length; i++) {
//            if (i==0){
//                if (split[0]=="#"){
//                    return false;
//                }
//                out+=2;
//                continue;
//            }
//            if (split[i]=="#"){
//                in++;
//            }else {
//                in++;
//                out+=2;
//            }
//            if (i<split.length-1 && out<=in){
//                return false;
//            }
//        }
//        return in == out;

    }

    public static void main(String[] args) {
        String a = "$";
        System.out.println(a.equalsIgnoreCase("$"));
    }
}