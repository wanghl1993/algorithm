package com.wanghl.algorithm.threadPool;

import java.io.Console;
import java.util.concurrent.*;

public class TestThreadPoolExecutor {

    public static void test(int size) {
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(5, 20, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));

        for (int i = 0; i < size; i++) {
            poolExecutor.execute(new DemoTask(i));


            System.out.println("poolSize:" + poolExecutor.getPoolSize());
            System.out.println("corePoolSize:" + poolExecutor.getCorePoolSize());
            System.out.println("maximumPoolSize:" + poolExecutor.getMaximumPoolSize());
            System.out.println("queue:" + poolExecutor.getQueue().size());
            System.out.println("completedTaskCount:" + poolExecutor.getCompletedTaskCount());
            System.out.println("largestPoolSize:" + poolExecutor.getLargestPoolSize());
            System.out.println("keepAliveTime:" + poolExecutor.getKeepAliveTime(TimeUnit.SECONDS));
            System.out.println("=====^^^=====");
        }

        poolExecutor.shutdown();
    }

    public static void main(String[] args) {
        test(3);
    }

    public static void main2(String[] args) {
        //创建使用单个线程的线程池
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            es1.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在执行任务");
                }
            });
        }
        //创建使用固定线程数的线程池
        ExecutorService es2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            es2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在执行任务");
                }
            });
        }
        //创建一个会根据需要创建新线程的线程池
        ExecutorService es3 = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            es3.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在执行任务");
                }
            });
        }
        //创建拥有固定线程数量的定时线程任务的线程池
        ScheduledExecutorService es4 = Executors.newScheduledThreadPool(2);
        System.out.println("时间：" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            es4.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
                }
            },3, TimeUnit.SECONDS);
        }
        //创建只有一个线程的定时线程任务的线程池
        ScheduledExecutorService es5 = Executors.newSingleThreadScheduledExecutor();
        System.out.println("时间：" + System.currentTimeMillis());
        for (int i = 0; i < 5; i++) {
            es5.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("时间："+System.currentTimeMillis()+"--"+Thread.currentThread().getName() + "正在执行任务");
                }
            },3, TimeUnit.SECONDS);
        }
    }

}
