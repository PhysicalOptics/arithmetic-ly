package com.leon.arithmetic.stonegame;

import org.apache.tools.ant.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
  * ClassName:    StoneGameII1140
  * @Description: 1140. 石子游戏II 
  * @Author:      liyang
  * @Date:        2022/2/25
  * version     1.0.0
 */
public class StoneGameII1140 {


    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {

            System.out.println(random.nextInt(50));
        }
        Collections.swap(list,1,3);
        list.forEach(System.out::println);
    }
}
