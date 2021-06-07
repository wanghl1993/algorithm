package com.wanghl.algorithm.threadPool;


import org.apache.commons.lang3.StringUtils;

public class DemoTask implements Runnable {

    private int taskNum;

    public DemoTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println(StringUtils.center("正在执行" + taskNum, 20, "="));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(StringUtils.center("执行完毕" + taskNum, 20, "="));
    }


}
