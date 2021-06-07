package com.wanghl.algorithm.c_001;

public class T3 {

    private int count = 10;
    public synchronized void m (){ // 等同于在方法的代码执行时要sychronized(this) 和T2.class一样
        count --;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

}
