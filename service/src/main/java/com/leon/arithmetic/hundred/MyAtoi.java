package com.leon.arithmetic.hundred;

import java.util.ArrayList;
import java.util.HashMap;

/**
  * ClassName:    MyAtoi
  * @Description: 8
  * @Author:      liyang
  * @Date:        2021/8/2
  * version     1.0.0
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 */
public class MyAtoi {
    public static void main(String[] args){
        ArrayList<HashMap<String, String>> urlMapList = new ArrayList<>();
        String s="机票L|Yweixinhbgj://start?type=weex&auth=true&hlo_module=hbgj&product_module=orderdetail&hlo_path=domeorderdetail&orderid=";
            String[] urlInfo = s.split("L\\|Y");
            HashMap<String, String> map = new HashMap<>();
            map.put("name",urlInfo[0]);
            map.put("url",urlInfo[1]);
            urlMapList.add(map);
        
    }
    public int myAtoi(String s) {
        if (s.length()==0)return 0;
        int flag = 1;
        int ret = 0;
        char[] str = s.toCharArray();
        int i = 0;
        while (str[i]==' ') {
            i++;
            if (s.length()==i) return 0;
        }
        if (str[i]=='-')flag = -1;
        if (str[i]=='+'||str[i]=='-')i++;
        while (i<s.length() && (str[i]>='0'&&str[i]<=9)){
            int in = str[i]-'0';
            if (ret>Integer.MAX_VALUE/10||(ret==Integer.MAX_VALUE/10&&in>7)){
                return flag>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            ret = ret*10+in;
            i++;
        }
        return flag>0?ret:-ret;
    }
}