package com.yjw.interview.thread;

/**
 * @author David Yang
 * @date 2020-02-04 11:26
 */
public class TestString {
}

class Test extends Thread {
    private String local;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public void run() {

    }
}
