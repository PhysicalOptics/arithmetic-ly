package com.leon.arithmetic.onehundred;

/**
  * ClassName:    HammingWeight
  * @Description: 191
  * @Author:      liyang
  * @Date:        2021/3/22
  * version     1.0.0
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n!=0){
            n&=n-1;
            ret++;
        }
        return ret;


//        int i = 1,ret = 0;
//        for (int j = 0; j <= 32; j++) {
//            if ((i&n)!=0){
//                ret++;
//            }
//            i<<=1;
//        }
//        return ret;
    }

    public static void main(String[] args){
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(Integer.MAX_VALUE));
    }

}