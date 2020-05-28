package com.wanghl.algorithm.test;

public class Xigua extends Decorator {
    public Xigua(Drink drink) {
        super(drink);
    }

    @Override
    public double money() {
        return super.money()+ 4.0;
    }

    @Override
    public String desc() {
        return super.desc() + "+西瓜";
    }
}
