package com.wanghl.algorithm.thread;

import org.openjdk.jol.info.ClassLayout;

public class HelloJOL {


    public static void main(String[] args) throws Exception {

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());


        /*o.hashCode();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());*/

        /*synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }*/
    }

}
