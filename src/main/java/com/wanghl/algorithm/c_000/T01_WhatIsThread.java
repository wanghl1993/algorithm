package com.wanghl.algorithm.c_000;

import java.util.concurrent.TimeUnit;

public class T01_WhatIsThread {

    private static class T1 extends Thread {
        @Override
        public void run() {

            for(int i = 0; i < 10; i++){
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }

        }
    }

    public static void main(String[] args) {
//        new T1().run(); //方法调用
        new T1().start(); // 产生分支,会和主程序一块运行
        for(int i = 0; i < 10; i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }

}
