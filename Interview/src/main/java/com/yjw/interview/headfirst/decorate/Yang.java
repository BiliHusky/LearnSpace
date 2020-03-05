package com.yjw.interview.headfirst.decorate;

/**
 * @author David Yang
 * @date 2020-02-12 10:39
 */
public class Yang implements Person{
    @Override
    public Double cost() {
        return 0.0;
    }

    @Override
    public void show() {
        System.out.println("Yang sir");
    }
}
