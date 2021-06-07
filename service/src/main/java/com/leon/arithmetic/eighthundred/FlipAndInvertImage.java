package com.leon.arithmetic.eighthundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * ClassName:    FlipAndInvertImage
  * @Description: 832
  * @Author:      liyang
  * @Date:        2021/2/24
  * version     1.0.0
 */
public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            int len = A[i].length;
            int l = 0;
            while (l < len-1-l){
                if (A[i][l] == A[i][len-l-1]){
                    A[i][l] ^=1;
                    A[i][len-l-1] ^=1;
                }
                l++;
            }
            if (l == len-l-1){
                A[i][l] ^=1;
            }
        }
        return A;
    }


    public static void main(String[] args){
        System.out.println(0^1);//取非
        Integer.valueOf("123");
        Double.valueOf("23.12");
        int[] ints = new int[2];
        int[] ints1 = {1, 2, 3};
        String[] ints2 = {"asd", "adf", "qer"};
        char[] chars = {'a', 'b', 'c'};
        String s = new String(chars);
        char[] chars1 = s.toCharArray();
        List<String> list = Arrays.asList(ints2);   // 不能修改
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList(ints2));  // 能修改

        // lambda


    }
}