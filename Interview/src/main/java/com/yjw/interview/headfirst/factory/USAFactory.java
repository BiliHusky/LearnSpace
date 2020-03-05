package com.yjw.interview.headfirst.factory;

/**
 * @author David Yang
 * @date 2020-02-12 15:44
 */
public class USAFactory extends AbstractFactory {
    @Override
    public Girl create(String type) {
        return new CNGirl();
    }
}
