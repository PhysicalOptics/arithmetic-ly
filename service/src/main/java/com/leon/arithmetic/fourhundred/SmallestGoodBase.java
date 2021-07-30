package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    SmallestGoodBase
  * @Description: 483
  * @Author:      liyang
  * @Date:        2021/6/18
  * version     1.0.0
 */
public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        Long a = Long.valueOf(n);

        for (int i = 59; i >1 ; i--) {
            long k = (long)Math.pow(a, 1 / i);
            if (k<1) continue;
            long s = 0;
            for (int j = 0; j <= i; j++) {
                s = s*k+1;
            }
            if (s==a) return String.valueOf(k);
        }
        /*for (int i = 2; i <= a/2; i++) {
            long yu = (a - 1) % i;
            if (yu >0) continue;
            long m = (a - 1) / i;
            while (m>i){
                if (m/i!=1&&m%i!=1)break;
                m=(m-1)/i;
            }
            if (m!=1) continue;
            if (m==1) return i+"";
        }*/
        return (a-1)+"";
    }
}