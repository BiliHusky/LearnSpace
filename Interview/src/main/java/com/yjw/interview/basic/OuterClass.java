package com.yjw.interview.basic;

/**
 * @author David Yang
 * @date 2020-02-21 17:55
 */
public class OuterClass {
    private static String ab;

    public void display(final String name,String age){
        class InnerClass{
            void display(){
                System.out.println(ab);
                System.out.println(name);
            }
        }
    }
}