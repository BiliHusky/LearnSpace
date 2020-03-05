package com.yjw.interview.headfirst.decorate;

/**
 * @author David Yang
 * @date 2020-02-12 10:41
 */
public class Shoe extends ClothDecorator{

    public Shoe(Person person) {
        super(person);
    }

    @Override
    public Double cost() {
        return person.cost() + 100;
    }

    @Override
    public void show() {
        person.show();
        System.out.println("Get shoe cost " + this.cost());
    }
}
