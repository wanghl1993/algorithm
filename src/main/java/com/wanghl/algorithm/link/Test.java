package com.wanghl.algorithm.link;

import java.util.LinkedList;

public class Test {

    public static void main(String [] arr) {
        LinkList g = new LinkList();
        g.addlast(13);
        g.addlast(16);
        g.addlast(-3);
        g.addlast(8);
        g.addlast(5);
        g.addlast(22);
        g.Min_to_Max();
        g.displayAllLink();
        g.Max_to_Min();
        g.displayAllLink();
        new LinkedList<>();
    }
}
