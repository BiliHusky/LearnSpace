package com.yjw.interview.headfirst.factory;

/**
 * @author David Yang
 * @date 2020-02-12 15:43
 */
public class CNFactory extends AbstractFactory {
    @Override
    public Girl create(String type) {
        Girl res = null;
        switch (type) {
            case "cn":
                res = new CNGirl();
                break;
            case "usa":
                res = new USAGirl();
                break;
            default:
                break;
        }
        return res;
    }
}
