package com.leon.arithmetic.threehundred;

/**
  * ClassName:    GuessNumber374
  * @Description: 374. 猜数字
  * @Author:      liyang
  * @Date:        2021/11/12
  * version     1.0.0
 */
public class GuessNumber374 {
    public static void main(String[] args){
        GuessNumber374 guessNumber374 = new GuessNumber374();
        guessNumber374.guessNumber2(10);
    }

    public int guessNumber2(int n) {
        int left = 1,right = n;
        while (left<right){
            int mid = left+(right-left)/2;
            System.out.println(mid);
            if (guess(mid)==0){
                return mid;
            }else if (guess(mid)>0){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
    public int guessNumber(int n) {
        int left = 1,right = n;
        while (left<right){
            int mid = left+(right-left)/2;
            System.out.println(mid);
            if (guess(mid)==0){
                return mid;
            }else if (guess(mid)>0){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
    int guess(int num){

        if (num==6) return 0;
        else if (num>6) return -1;
        else return 1;
    }
}