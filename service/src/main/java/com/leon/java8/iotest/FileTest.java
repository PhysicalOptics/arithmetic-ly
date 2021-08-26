package com.leon.java8.iotest;

import java.io.File;

/**
  * ClassName:    FileTest
  * @Description: 文件流测试
  * @Author:      liyang
  * @Date:        2021/8/23
  * version     1.0.0
 */
public class FileTest {

    public static void main(String[] args){
//        File file = new File("D:\test.txt");
        //目录
        File sanGuo = new File("D:/四大名著/三国");
        // 创建失败，mkdirs返回的是true，创建级联目录，mkdir返回的是false，不能创建级联目录
        boolean mkdirs = sanGuo.mkdirs();
        //删除也是先声明对象，再删除，目录不为空时删除失败
//        sanGuo.delete();

        // 判断文件类型isDirectory();isFile();exists()
        sanGuo.exists();
        // 文件属性获取
        String absolutePath = sanGuo.getAbsolutePath();System.out.println(absolutePath);
        // 获取相对路径
        String path = sanGuo.getPath();System.out.println(path);
    }
}