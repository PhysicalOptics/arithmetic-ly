package com.leon.arithmetic.hundred;

import java.util.HashMap;
import java.util.LinkedList;

/**
  * ClassName:    IsValid
  * @Description: 20
  * @Author:      liyang
  * @Date:        2021/4/21
  * version     1.0.0
 */
public class IsValid {
    public boolean isValid(String s){
        int length = s.length();
        if (length%2>0) return false;
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put('}','{');
        charMap.put(']','[');
        charMap.put(')','(');
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)){
                if (stack.isEmpty()||stack.peek()!=charMap.get(c)){
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}