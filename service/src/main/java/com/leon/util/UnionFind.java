package com.leon.util;

import java.util.Arrays;

/**
 * ClassName:    UniteFind
 *
 * @Description: 并集查
 * @Author: liyang
 * @Date: 2021/11/4
 * version     1.0.0
 */
// 并查集模板
public class UnionFind {

    int[] parent;
    int[] size;
    int n;
    // 当前连通分量数目
    int setCount;

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public boolean  unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        if (size[x] < size[y]) {
            parent[x] = y;
            size[y] += size[x];
        }else {
            parent[y] = x;
            size[x] += size[y];
        }
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

}