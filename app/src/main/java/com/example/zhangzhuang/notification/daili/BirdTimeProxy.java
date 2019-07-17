package com.example.zhangzhuang.notification.daili;

public class BirdTimeProxy implements Flyable {
    private Flyable flyable;

    public BirdTimeProxy(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        System.out.println("111111");
        flyable.fly();
        System.out.println("222222");
        long end = System.currentTimeMillis();
        System.out.println("fly time:"+(end-start));
    }
}
