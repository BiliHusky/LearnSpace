package com.yjw.interview.headfirst.decorate;

/**
 * @author David Yang
 * @date 2020-02-12 10:49
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Yang();

        person = new Shoe(person);
        person = new Jacket(person);
        person.show();


    }
}
