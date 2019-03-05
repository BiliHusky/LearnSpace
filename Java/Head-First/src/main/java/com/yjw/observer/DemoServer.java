package com.yjw.observer;

import java.util.ArrayList;

/**
 * Created by yjw on 18-11-28.
 */
public class DemoServer implements CenterServer {
    private ArrayList clients;
    public DemoServer() {
        clients = new ArrayList();
    }
    public void register(Client client) {
        clients.add(client);
        notifyClient();
    }

    public void exit(Client client) {
        int i = clients.indexOf(client);
        if (i >= 0) {
            clients.remove(i);
        }
        notifyClient();
    }

    public void notifyClient() {
        for (int i=0; i<clients.size(); i++) {
            Client client = (Client) clients.get(i);
            client.getClientList(clients.size());
        }
    }
}
