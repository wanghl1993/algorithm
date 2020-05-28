package com.wanghl.algorithm.test;

public abstract class Decorator implements Drink {

    //装饰器
    //1,抽象类
    //2.实现抽象组件接口
    //3.持有抽象接口的引用

    //定义私有的饮品接口引用
    private Drink drink;
    public Decorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public double money() {
        return drink.money();
    }

    @Override
    public String desc() {
        return drink.desc();
    }
}
