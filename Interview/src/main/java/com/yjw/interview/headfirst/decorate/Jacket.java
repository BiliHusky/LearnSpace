package com.yjw.interview.headfirst.decorate;

/**
 * @author David Yang
 * @date 2020-02-12 10:45
 */
public class Jacket extends ClothDecorator{

    public Jacket(Person person) {
        super(person);
    }

    @Override
    public Double cost() {
        return person.cost() + 110;
    }

    @Override
    public void show() {
        person.show();
        System.out.println("get Jacket cost " + this.cost());
    }
}
