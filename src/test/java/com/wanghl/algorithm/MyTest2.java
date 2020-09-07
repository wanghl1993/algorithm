package com.wanghl.algorithm;

import com.wanghl.algorithm.annotation.Autowired;
import com.wanghl.algorithm.controller.UserController;
import com.wanghl.algorithm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class MyTest2 {

    @Test
    public void test(){
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();

//        UserService userService = new UserService();
        // 获取所有的属性值
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            Autowired annotation = field.getAnnotation(Autowired.class);
            if(annotation != null){
                field.setAccessible(true);
                // 获取属性的类型
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(userController, o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });
        System.out.println(userController.getUserService());

    }

}
