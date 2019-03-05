package com.yjw.observer;

/**
 * Created by yjw on 18-11-28.
 */
public class Test {
    public static void main(String[] args) {
        DemoServer server = new DemoServer();
        DemoClient c1 = new DemoClient(server);
        System.out.println("after c1 enter");
        System.out.println("c1 " + c1.getCount());
        DemoClient c2 = new DemoClient(server);
        System.out.println("after c2 enter");
        System.out.println("c1 " + c1.getCount());
        System.out.println("c2 " + c2.getCount());
        DemoClient c3 = new DemoClient(server);
        System.out.println("after c3 enter");
        System.out.println("c1 " + c1.getCount());
        System.out.println("c3 " + c3.getCount());

        server.exit(c2);
        System.out.println("after c2 exit");
        System.out.println("c1 " + c1.getCount());
        System.out.println("c2 " + c2.getCount());
        System.out.println("c3 " + c3.getCount());

    }
}
