package com.leon.java8.reflect.staticproxy;

/**
  * ClassName:    AdminServiceImpl
  * @Description: 实现类
  * @Author:      liyang
  * @Date:        2021/8/5
  * version     1.0.0
 */
public class AdminServiceProxy implements AdminService{

    private AdminService adminService;

    public AdminServiceProxy(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void update(String auth) {
        System.out.println("进入的是代理类的update方法");
        adminService.update(auth);
    }

    @Override
    public String find() {
        System.out.println("进入的是代理类的find方法");
        return adminService.find();
    }
}