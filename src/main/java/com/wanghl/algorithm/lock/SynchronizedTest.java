package com.wanghl.algorithm.lock;

public class SynchronizedTest {


    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedTest.synchronizedMethodOnClass(3000);
            }
        }, "Thread static synchronized method").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.synchronizedBlockOnClass(2000);
            }
        }, "Thread synchronized block on Class").start();
    }


    private Object lock = new Object();

    public void synchronizedBlockOnObject(long executeTime) {
        // lock对象锁
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnObject");
            doSomething(executeTime);
            System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnObject");
        }
    }

    public void synchronizedBlockOnThis(long executeTime) {
        // 当前实例对象锁
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnThis");
            doSomething(executeTime);
            System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnThis");
        }
    }

    public void synchronizedBlockOnClass(long executeTime) {
        // 类锁
        synchronized (SynchronizedTest.class) {
            System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnClass");
            doSomething(executeTime);
            System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnClass");
        }
    }

    // 非静态方法，当前实例对象锁
    public synchronized void synchronizedMethodOnThis(long executeTime) {
        System.out.println(Thread.currentThread().getName() + " -> start synchronizedMethodOnThis");
        doSomething(executeTime);
        System.out.println(Thread.currentThread().getName() + " -> end synchronizedMethodOnThis");
    }

    // 静态方法，类锁（SynchronizedTest.class）
    public static synchronized void synchronizedMethodOnClass(long executeTime) {
        System.out.println(Thread.currentThread().getName() + " -> start synchronizedMethodOnClass");
        doSomething(executeTime);
        System.out.println(Thread.currentThread().getName() + " -> end synchronizedMethodOnClass");
    }

    private static void doSomething(long executeTime) {
        try {
            Thread.sleep(executeTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
