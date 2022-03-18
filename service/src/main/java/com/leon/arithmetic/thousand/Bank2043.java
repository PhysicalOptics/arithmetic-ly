package com.leon.arithmetic.thousand;

/**
  * ClassName:    Bank2043
  * @Description: 2043. 简易的银行系统
  * @Author:      liyang
  * @Date:        2022/3/18
  * version     1.0.0
 */
public class Bank2043 {

    long[] balance;

    public Bank2043(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1>balance.length||account2>balance.length) return false;
        account1-=1;
        account2-=1;
        if (balance[account1]>=money){
            balance[account1] = balance[account1]-money;
            balance[account2] = balance[account2]+money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (account>balance.length) return false;
        account-=1;
        balance[account]+=money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account>balance.length) return false;
        account-=1;
        if (balance[account]>=money){
            balance[account]-=money;
            return true;
        }
        return false;
    }
}