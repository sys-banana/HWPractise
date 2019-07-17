package com.example.zhangzhuang.notification.daili;

public class MainTest {
    public static void main(String[] args) {
        Bird bird = new Bird();
        BirdLogProxy p1 = new BirdLogProxy(bird);
        BirdTimeProxy p2 = new BirdTimeProxy(p1);
        p2.fly();

        BirdTimeProxy p11 = new BirdTimeProxy(bird);
        BirdLogProxy p22 = new BirdLogProxy(p11);
        p22.fly();
    }
}
