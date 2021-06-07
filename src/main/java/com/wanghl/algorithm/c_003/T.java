package com.wanghl.algorithm.c_003;

/**
 *  分析这个程序的输出
 */
public class T implements Runnable {

    private int count = 100;

    @Override
    public /* synchronized */ void run() {  // synchronized 既保证了原子性又保证了可见性
        count --;
        System.out.println(Thread.currentThread().getName() + " count = " +
                count);
    }

    public static void main(String[] args) {
        T t = new T();
        for(int i=0; i<100; i++){
            new Thread(t,"THREAD" + i).start();
        }
    }
//    @Override
//    public void run() {
//
//    }
}
