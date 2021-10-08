package com.leon.arithmetic.eighthundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
  * ClassName:    SubdomainVisits811
  * @Description: 域名访问次数811
  * @Author:      liyang
  * @Date:        2021/9/29
  * version     1.0.0
 */
public class SubdomainVisits811 {

    public static void main(String[] args){
        SubdomainVisits811 sub = new SubdomainVisits811();
        sub.subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            Integer times = Integer.valueOf(split[0]);
            String[] domains = split[1].split("\\.");
            for (int i = 0; i < domains.length; i++) {
                String domain = "";
                for (int j = i; j < domains.length; j++) {
                    domain += domains[j];
                    if (j!=(domains.length-1)) domain+=".";
                }
                map.put(domain,map.getOrDefault(domain,0)+times);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            String PV = map.get(s)+" "+s;
            list.add(PV);
        }
        return list;
    }


}