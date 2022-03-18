package com.leon.arithmetic.fourhundred;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
  * ClassName:    AllOne432
  * @Description: 432. 全O(1)数据结构
  * @Author:      liyang
  * @Date:        2022/3/16
  * version     1.0.0
 */
public class AllOne432 {

    class Node {
        int cnt;
        Set<String> set = new HashSet<>();
        Node left, right;
        Node(int _cnt) {
            cnt = _cnt;
        }
    }

    Node hh, tt;
    Map<String, Node> map = new HashMap<>();
    public AllOne432() {
        hh = new Node(-1000); tt = new Node(-1000);
        hh.right = tt; tt.left = hh;
    }

    void clear(Node node) {
        if (node.set.size() == 0) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            // 如果包含则取出node，并删除node的set里的key，拿到当前node的计数
            Node node = map.get(key);
            node.set.remove(key);
            int cnt = node.cnt;
            // 如果node的下一个是cnt+1,则可以直接放入下一个node的set中
            Node next = null;
            if (node.right.cnt == cnt + 1) {
                next = node.right;
            } else {
                // 如果node下一个不是cnt+1，则需要创建一个新node（cnt+1）加入
                next = new Node(cnt + 1);
                next.right = node.right;
                next.left = node;
                node.right.left = next;
                node.right = next;
            }
            // 将node的set加入key,并重新覆盖map里key-node值，清楚之前node
            next.set.add(key);
            map.put(key, next);
            clear(node);
        } else {
            Node node = null;
            if (hh.right.cnt == 1) {
                // 不包含且已经有计数为1的node，则直接在node的set里加入key
                node = hh.right;
            } else {
                // 双向链表无元素，第一个添加，而且是往head节点添加
                node = new Node(1);
                node.right = hh.right;
                node.left = hh;
                hh.right = node;
                node.right.left = node;
            }
            node.set.add(key);
            map.put(key, node);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.set.remove(key);
        int cnt = node.cnt;
        // 如果只有一个，则清楚map里的key
        if (cnt == 1) {
            map.remove(key);
        } else {
            // 如果不止一个
            Node prev = null;
            // 如果上一个的计数为当前cnt-1，则直接取上一个往set中加入key
            if (node.left.cnt == cnt - 1) {
                prev = node.left;
            } else {
                //如果上一个不是cnt-1,则需要重新创建一个节点，加到上一个
                prev = new Node(cnt - 1);
                prev.right = node;
                prev.left = node.left;
                node.left.right = prev;
                node.left = prev;
            }
            // 往set加入key，更新map中key的节点
            prev.set.add(key);
            map.put(key, prev);
        }
        // 清除
        clear(node);
    }

    public String getMaxKey() {
        Node node = tt.left;
        for (String str : node.set) return str;
        return "";
    }

    public String getMinKey() {
        Node node = hh.right;
        for (String str : node.set) return str;
        return "";
    }

}