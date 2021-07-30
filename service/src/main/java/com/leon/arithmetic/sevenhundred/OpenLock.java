package com.leon.arithmetic.sevenhundred;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    OpenLock
  * @Description: 752
  * @Author:      liyang
  * @Date:        2021/7/22
  * version     1.0.0
 */
public class OpenLock {
    public static void main(String[] args){
        OpenLock openLock = new OpenLock();
        System.out.println(openLock.openLock2(new String[]{"0201","0101","0102","1212","2002"},"0202"));
    }
    public int openLock2(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            if (deadend.equalsIgnoreCase("0000")) return -1;
            visited.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer(target);
        visited.add(target);
        int setp = 0;
        while (!queue.isEmpty() && !queue2.isEmpty()){
//            HashSet<String> temp = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (queue2.contains(cur)) return setp;
                for (int j = 0; j < 4; j++) {
                    String s = plusOne(cur, j);
                    if (queue2.contains(s)) return setp+1;
                    if (!visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                    String s1 = minusOne(cur, j);
                    if (queue2.contains(s1)) return setp+1;
                    if (!visited.contains(s1)){
                        queue.offer(s1);
                        visited.add(s1);
                    }
                }
            }
            setp++;
            if (queue.size()>queue2.size()){
                Queue<String> temp = queue;
                queue = queue2;
                queue2 = temp;

            }
        }
        return -1;

    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            if (deadend.equalsIgnoreCase("0000")) return -1;
            visited.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int setp = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equalsIgnoreCase(target)) return setp;
                for (int j = 0; j < 4; j++) {
                    String s = plusOne(cur, j);
                    if (!visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                    String s1 = minusOne(cur, j);
                    if (!visited.contains(s1)){
                        queue.offer(s1);
                        visited.add(s1);
                    }
                }
            }
            setp++;
        }
        return -1;
    }

    private String plusOne(String s,int i){
        char[] chars = s.toCharArray();
        if (chars[i]=='9'){
            chars[i] = '0';
        }else {
            chars[i] +=1;
        }
        return new String(chars);
    }

    private String minusOne(String s,int i){
        char[] chars = s.toCharArray();
        if (chars[i]=='0'){
            chars[i] = '9';
        }else {
            chars[i] -=1;
        }
        return new String(chars);
    }
}