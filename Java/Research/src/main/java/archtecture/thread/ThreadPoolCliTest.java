package archtecture.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by yjw on 18-9-6.
 */
public class ThreadPoolCliTest {
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;
        DataOutputStream out = null;
        Socket client = null;
        String hostname = "10.1.10.68";
        int port = 9999;
        client = new Socket(hostname, port);
        out = new DataOutputStream(client.getOutputStream());
        long rr = System.currentTimeMillis();
        out.writeUTF(("cli:"+rr));
    }
}
