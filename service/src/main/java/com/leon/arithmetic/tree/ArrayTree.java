package com.leon.arithmetic.tree;

/**
  * ClassName:    ArrayTree
  * @Description: 二叉树，数组实现
  * @Author:      liyang
  * @Date:        2020/8/17
  * version     1.0.0
 */
public class ArrayTree<T> {
    private T[] data;
    private int deep;
    private int MaxSize;
    private int size = 0;
    public ArrayTree(int deep){
        this.deep = deep;
        //根据二叉树的深度计算元素的最大个数
        MaxSize = (int)Math.pow(2, deep)-1;
        data = (T[]) new Object[MaxSize];
    }
    /**
     *
     * @param value 根节点的值
     */
    public void creatRoot(T value){
        data[0] = value;
        size++;
    }
    /**
     * @param value 添加的节点的值
     * @param index 父节点的索引
     * @param left 是否添加到左节点，否则为右节点
     * */
    public void add(T value,int index,boolean left){
        if(data[index] == null){
            throw new RuntimeException(index + ": null");
        }
        if(2*index+1 >= MaxSize){
            throw new RuntimeException("array full");
        }
        if(left){
            data[2*index+1] = value;
            size++;
        }
        else{
            data[2*index+2] =  value;
            size++;
        }
    }
    //根据根节点是否为空判断二叉树是否为空
    public boolean isEmpty(){
        return data[0]==null;
    }

    //二叉树中元素的个数
    public int size(){
        return this.size;
    }
    //打印二叉树
    public String toString(){
        String str = "";
        for(int i=0; i<MaxSize; i++){
            str = str + data[i] + " ";
        }
        return str;
    }
    public static void main(String args[]){
        ArrayTree<String> at = new ArrayTree<String>(3);
        /**
         *                 根节点
         *     第二层左节点         第二层右节点
         *         第三层右节点  第三层左节点
         */
        at.creatRoot("根节点");
        at.add("第二层左节点", 0, true);
        at.add("第二层右节点", 0, false);
        at.add("第三层右节点", 1, false);
        System.out.println(at.toString());
        at.add("第三层左节点", 2, true);
        System.out.println(at.toString());
        System.out.println("二叉树元素个数： " + at.size());
    }
}
