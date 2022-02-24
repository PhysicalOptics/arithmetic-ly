package com.leon.arithmetic.twohundred;

import cn.hutool.core.util.ArrayUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.tools.ant.util.CollectionUtils;

import java.util.*;

/**
  * ClassName:    CourseCanFinishI207
  * @Description: 207. 课程表1
  * @Author:      liyang
  * @Date:        2021/12/14
  * version     1.0.0
 */
public class CourseCanFinishI207 {

    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<>();
        map.put("1","1");
        System.out.println(map.get("2"));

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<LinkedList<Integer>> graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < graph.size(); i++) {
            boolean[] visit = new boolean[numCourses];
            boolean[] onPath = new boolean[numCourses];
            traverse(graph,i,visit,onPath);
        }
        return !hasCycle;
    }

    private boolean hasCycle = false;

    public void traverse(List<LinkedList<Integer>> graph,int c,boolean[] visit,boolean[] onPath){
        if (onPath[c]) hasCycle = true;
        if (visit[c]) return;
        LinkedList<Integer> list = graph.get(c);
        if (list.size()==0) return;
        visit[c]=true;
        onPath[c] = true;
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i).intValue();
            traverse(graph,index,visit,onPath);
        }
        visit[c] = false;
        onPath[c] = false;
    }

    public List<LinkedList<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<Integer>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}