package com.wanghl.algorithm.c_000;

import java.util.concurrent.TimeUnit;

public class T03_Sleep_Yield_Join {

    public static void main(String[] args) {
        testSleep();
        testYield();
        testJoin();
    }

    static void testSleep() {
        new Thread(() ->{
            for(int i = 0; i < 100; i++){
                System.out.println("A" + i);
                try {
                    Thread.sleep(500); // 可以让给别的线程去运行
//                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void testYield() {
        new Thread(() -> {
            for(int i=0; i < 100; i++){
                System.out.println("A" + i);
                if(i % 10 == 0){
                    Thread.yield(); //让出一下CPU,返回到就绪状态
                }
            }
        }).start();

        new Thread(() -> {
            for(int i=0; i < 100; i++){
                System.out.println("-----B" + i);
                if(i % 10 == 0){
                    Thread.yield();
                }
            }
        }).start();
    }

    static void testJoin() {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
//                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();  //等t1结束,t2在运行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

}
