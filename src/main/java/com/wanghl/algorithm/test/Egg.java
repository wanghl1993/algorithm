package com.wanghl.algorithm.test;

public class Egg extends Decorator {
    public Egg(Drink drink) {
        super(drink);
    }

    @Override
    public double money() {
        return super.money() + 3.9;
    }

    @Override
    public String desc() {
        return super.desc() + "+鸡蛋";
    }
}
