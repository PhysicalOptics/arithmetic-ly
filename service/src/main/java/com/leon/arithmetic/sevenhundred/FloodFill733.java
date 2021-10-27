package com.leon.arithmetic.sevenhundred;

import java.util.LinkedList;
import java.util.Queue;

/**
  * ClassName:    FloodFill733
  * @Description: 733. 图像渲染
  * @Author:      liyang
  * @Date:        2021/10/20
  * version     1.0.0
 */
public class FloodFill733 {
    public static void main(String[] args){
        FloodFill733 fill733 = new FloodFill733();
        fill733.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int base = image[sr][sc];
        boolean[][] changed = new boolean[image.length][image[0].length];
        Queue<String> queue = new LinkedList<>();
        queue.offer(sr + "," + sc);
        while (queue.size()>0){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                String[] srsc = poll.split(",");
                Integer sri = Integer.valueOf(srsc[0]);
                Integer sci = Integer.valueOf(srsc[1]);
                image[sri][sci] = newColor;
                changed[sri][sci] = true;
                //上
                if (sri - 1 >= 0 && !changed[sri - 1][sci] && image[sri - 1][sci] == base) {
                    queue.offer((sri - 1) + "," + sci);
                }
                //下
                if (sri + 1 < image.length && !changed[sri + 1][sci] && image[sri + 1][sci] == base) {
                    queue.offer((sri + 1) + "," + sci);
                }
                //左
                if (sci - 1 >= 0 && !changed[sri][sci - 1] && image[sri][sci - 1] == base) {
                    queue.offer(sri + "," + (sci - 1));
                }
                //右
                if (sci + 1 < image[0].length && !changed[sri][sci + 1] && image[sri][sci + 1] == base) {
                    queue.offer(sri + "," + (sci + 1));
                }
            }
        }
        return image;
    }
}