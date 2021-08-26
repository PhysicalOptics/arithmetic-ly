package com.leon.java8.reflect.staticproxy;

/**
  * ClassName:    Test
  * @Description:   特点：文件编译之前就实现代理
  *                 缺点：改接口类时，实现类和代理类都需要改
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 *
 */
public class Test {

    public static void main(String[] args){
        AdminService adminService = new AdminServiceImpl();
        AdminServiceProxy adminServiceProxy = new AdminServiceProxy(adminService);
        adminServiceProxy.update("123");
        adminServiceProxy.find();
    }
}