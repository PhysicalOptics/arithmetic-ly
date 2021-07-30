package com.leon.arithmetic.offer;

/**
  * ClassName:    CuttingRope
  * @Description: 14
  * @Author:      liyang
  * @Date:        2021/6/22
  * version     1.0.0
 *
 * 题解：2，3不可拆，4拆了和没拆一样，看能拆成多少个3
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        int a = n/3,b = n%3;
        if (n<=3) return n-1;
        if (b==0) return (int)Math.pow(3,a);
        if (b==1) return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a)*2;
    }

    public int cuttingRope3(int n) {
        if(n <= 3) return n - 1;
        long res=1L;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }

    public int cuttingRope2(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);

    }
}