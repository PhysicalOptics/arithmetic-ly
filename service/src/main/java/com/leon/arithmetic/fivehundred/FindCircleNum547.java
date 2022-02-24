package com.leon.arithmetic.fivehundred;

import com.leon.util.TransSZ;
import org.apache.tools.ant.types.resources.Union;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
  * ClassName:    FindCircleNum547
  * @Description: 547. 寻找省份数量
  * @Author:      liyang
  * @Date:        2021/12/14
  * version     1.0.0
 */
public class FindCircleNum547 {

    public static void main(String[] args){
        String trans = TransSZ.trans("[[1,0,0,0,1],[0,1,1,1,0],[0,1,1,0,1],[0,1,0,1,0],[1,0,1,0,1]]");
        System.out.println(trans);

    }
    
    // 归并集
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        int[] size = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent,size, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent,int[] size, int index1, int index2) {
        int p1 = find(parent, index1);
        int p2 = find(parent, index2);
        if (p1 == p2) return;
        if (size[p1]>size[p2]){// 2往1上合并 --优化小树往大数上靠
            parent[p2] = p1;
            size[p1]+=size[p2];
        }else {// 1往2上合并
            parent[p1] = p2;
            size[p2]+=size[p1];
        }
    }

    public int find(int[] parent, int index) {
        //法一 递归-未优化
        //return parent[index] == index ? index:find(parent,parent[index]);
        //法二 while循环-未优化
        //while (parent[index]!=index){
        //    index = parent[index];
        //}
        //return index;
        //法三 while循环-优化后压缩
        //while (parent[index]!=index){
        //    parent[index] = parent[parent[index]];
        //    index = parent[index];
        //}
        //return index;
        //法四 递归-优化后
        if (parent[index]!=index){
            parent[index] = parent[parent[index]];
            return find(parent, parent[index]);
        }
        return index;
    }



    // 可简化主函数中双重循环，dfs会进行一层循环
    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j]==1){
                    count++;
                    isConnected[i][j] = 0;
                    dfs(i*n+j,isConnected);
                }
            }
        }
        return count;
    }
    private int[] dic = {-1,0,1,0,-1};

    public void dfs(int curr,int[][] isConnected){
        int n = isConnected.length;
        int x = curr / n;
        int y = curr % n;
        for (int i = 0; i < n; i++) {
            if (isConnected[x][i]==1){
                isConnected[x][i]= 0;
                dfs(x*n+i,isConnected);
            }
            if (isConnected[i][y]==1){
                isConnected[i][y]=0;
                dfs(i*n+y,isConnected);
            }
        }
    }
}