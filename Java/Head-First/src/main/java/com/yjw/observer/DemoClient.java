package com.yjw.observer;

/**
 * Created by yjw on 18-11-28.
 */
public class DemoClient implements Client{
    private DemoServer server;
    private int count;

    public DemoClient(DemoServer server) {
        this.server = server;
        this.server.register(this);
    }


    public void getClientList(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
