package com.leon.arithmetic.onehundred;

/**
  * ClassName:    MaxSatisfied
  * @Description: 1052
  * @Author:      liyang
  * @Date:        2021/2/23
  * version     1.0.0
 */
public class MaxSatisfied {

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0){
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int num = customers[0];
        int maxval = customers[0];
        for (int i = 1; i < len; i++){
            if (i < X) num = num + customers[i];
            else num = num + customers[i] - customers[i - X];
            maxval = Math.max(maxval, num);
        }

        return (sum + maxval);

        //        int ret=0,l=0,add=0;
//        for (int i = 0; i < X; i++) {
//            add += customers[i]*grumpy[i];
//        }
//        int temp = add;
//        while (l<customers.length){
//            if (grumpy[l]==0){
//                ret+=customers[l];
//            }
//            if (l>=X){
//                temp = temp-customers[l-X]*grumpy[l-X]+customers[l]*grumpy[l];
//            }
//            add = Math.max(temp,add);
//            l++;
//
//        }
//        return  ret+add;
    }


    public static void main(String[] args){
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy =    {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(maxSatisfied(customers,grumpy,3));

    }

}