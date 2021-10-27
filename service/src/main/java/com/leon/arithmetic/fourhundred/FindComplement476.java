package com.leon.arithmetic.fourhundred;

/**
  * ClassName:    FindComplement476
  * @Description: 476. 补数
  * @Author:      liyang
  * @Date:        2021/10/18
  * version     1.0.0
 */
public class FindComplement476 {

    // 法二
    public int findComplement2(int num) {
        int x= 0;
        // 寻找最高位10000   i 最低位如果是0，-i 取反加一则是10（向上进位），i&-i = 第一个最高位10000...
        //                              1,-i取反加一则是1，i&-i=1
        for (int i = num; i !=0 ; i-= i&-i) {
            x= i;
        }
        return ~num&(x-1);
    }

    public int findComplement(int num) {
        int s = -1;  // 11111111 11111111 11111111 11111111
        // 从高到低寻找num的最高1位置,s为第s位为1的
        for (int i = 31; i >=0 ; i--) {
            if (((num>>i)&1)!=0){
                s = i;
                break;
            }
        }
        return  ~num & ((1 << s) - 1);
        //int ans = 0;
        //
        //for (int i = 0; i < s; i++) {
        //    // 如果当前位为0，则ans当前为取1
        //    if (((num>>i)&1)==0) ans|=(1<<i);
        //}
        //return ans;
    }
}