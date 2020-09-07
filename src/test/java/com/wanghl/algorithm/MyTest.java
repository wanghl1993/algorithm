package com.wanghl.algorithm;

import com.wanghl.algorithm.controller.UserController;
import com.wanghl.algorithm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpringBootTest
public class MyTest {

    @Test
    public void test() throws Exception{

        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

        // 创建对象
        UserService userService = new UserService();
        System.out.println(userService);

        // 获取所有的操作
        Field serviceField = clazz.getDeclaredField("userService");
        serviceField.setAccessible(true);
        // 只有通过方法才能够设置具体的属性值
        String name = serviceField.getName();
        // 拼接方法的名称
        name = name.substring(0,1).toUpperCase() + name.substring(1, name.length());
        String setMethodName = "set" + name;
        // 通过方法注入属性的对象
        Method method = clazz.getMethod(setMethodName, UserService.class);
        // 反射
        method.invoke(userController, userService);  // 不反射 则为null
        System.out.println(userController.getUserService());

    }

}
