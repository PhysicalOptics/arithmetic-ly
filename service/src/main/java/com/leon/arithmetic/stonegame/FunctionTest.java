package com.leon.arithmetic.stonegame;

/**
 * ClassName:    StoneGame877
 *
 * @Description: 877. 石头游戏
 * @Author: liyang
 * @Date: 2022/2/25
 * version     1.0.0
 */

public class FunctionTest {
    private String name;

    FunctionTest(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        //LineHandler aNew = FunctionTest::new;
        com.leon.arithmetic.stonegame.A com = FunctionTest::new;
        com.leon.arithmetic.stonegame.FunctionTest bean = com.create("hello world");
        System.out.println(bean.name);
    }
}

@FunctionalInterface
interface A {
    FunctionTest create(String name);

    static void ad() {
        System.out.println("static");
    }

    default String ps() {
        System.out.println("default");
        return "1";
    }
}