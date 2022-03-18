package com.leon.arithmetic.sevenhundred;

import cn.hutool.json.JSONUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
  * ClassName:    LongestWord720
  * @Description: 720. 词典中最长的词
  * @Author:      liyang
  * @Date:        2022/3/17
  * version     1.0.0
 */
public class LongestWord720 {
    
    public static void main(String[] args){
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        //Arrays.sort(strings,(t1,t2)->t1.length()-t2.length());
        LongestWord720 word720 = new LongestWord720();
        String s = word720.longestWord(words);
        System.out.println(s);
    }
    
    public String longestWord(String[] words) {
        //Arrays.sort(words,(t1,t2)->t1.length()-t2.length());
        //if (words[0].length()>1) return "";
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            List<String> list = map.getOrDefault(word.length(), new ArrayList<String>());
            list.add(word);
            map.put(word.length(),list);
        }
        List<String> pre = new ArrayList<>();
        pre=map.get(1);
        if (pre==null||pre.size()<1)return "";
        for (int i = 2; i <= map.keySet().size(); i++) {
            List<String> strings = map.get(i);
            if (strings==null||strings.size()==0) return pre.get(0);
            List<String> curr = new ArrayList<>();
            for (String s : strings) {
                for (String p : pre) {
                    if (s.indexOf(p)>-1){
                        curr.add(s);
                        break;
                    }
                }
            }

            if (curr.size()==0) return pre.get(0);
            // 按照字典的字母排序  ["m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"]
            else if (curr.size()>1){
                Collections.sort(curr,(s1,s2)->s1.compareTo(s2));
            }
            pre = curr;

        }
        return pre.get(0);
    }
}