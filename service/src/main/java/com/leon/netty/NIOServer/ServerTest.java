package com.leon.netty.NIOServer;

import java.io.Serializable;
import java.nio.channels.ServerSocketChannel;

/**
  * ClassName:    ServerTest
  * @Description: nio测试
  * @Author:      liyang
  * @Date:        2021/9/6
  * version     1.0.0
 */
public class ServerTest implements Serializable {

    public static void main(String[] args) {
        try(ServerSocketChannel open = ServerSocketChannel.open()) {

        }catch (Exception e){
            System.out.println("e");
        }
    }
}