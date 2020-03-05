package com.yjw.interview.headfirst.decorate;

/**
 * @author David Yang
 * @date 2020-02-12 10:42
 */
public abstract class ClothDecorator implements Person{
    protected Person person;

    public ClothDecorator(Person person) {
        this.person = person;
    }
}
