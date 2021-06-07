package com.leon.arithmetic.thousand;

/**
  * ClassName:    Clumsy
  * @Description: 1006
  * @Author:      liyang
  * @Date:        2021/4/1
  * version     1.0.0
 */
public class Clumsy {
    public int clumsy(int N) {
        if (N<3)return N;
        if (N==3)return 6;
        if (N==4)return 7;
        if (N>4){
            int i = N % 4;
            if (i==0){
                return N+1;
            }else if (i <3){
                return N+2;
            }else {
                return N-1;
            }
        }
        return 0;
    }
}