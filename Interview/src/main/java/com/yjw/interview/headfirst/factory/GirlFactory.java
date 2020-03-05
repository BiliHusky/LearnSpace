package com.yjw.interview.headfirst.factory;

/**
 * @author David Yang
 * @date 2020-02-12 15:45
 */
public class GirlFactory {
    private AbstractFactory factory;

    public GirlFactory(AbstractFactory factory) {
        this.factory = factory;
    }

    public Girl createGirl(String type) {
        return factory.create(type);
    }


    public static void main(String[] args) {
        GirlFactory ff =  new GirlFactory(new CNFactory());
        Girl g = ff.createGirl("usa");
        g.show();
    }
}
