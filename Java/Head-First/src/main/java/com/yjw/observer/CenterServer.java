package com.yjw.observer;

/**
 * Created by yjw on 18-11-28.
 */
public interface CenterServer {
    void register(Client client);
    void exit(Client client);
    void notifyClient();
}
