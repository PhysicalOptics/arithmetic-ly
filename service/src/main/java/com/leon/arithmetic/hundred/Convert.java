package com.leon.arithmetic.hundred;

import java.util.ArrayList;

/**
  * ClassName:    Convert
  * @Description: 6
  * @Author:      liyang
  * @Date:        2021/3/19
  * version     1.0.0
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows ==1 ){
            return s;
        }
        ArrayList<StringBuffer> arrayLists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            arrayLists.add(new StringBuffer());
        }
        int row = 0; int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            arrayLists.get(row).append(s.charAt(i));
            if (row==numRows-1||row == 0) flag = -flag;
            row+=flag;
        }
        StringBuffer ret = new StringBuffer();
        for (StringBuffer sb : arrayLists) {
            ret.append(sb);
        }
        return ret.toString();
    }
}