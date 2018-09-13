package archtecture.unkownclass;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by yjw on 18-9-7.
 */
public class InternetAddrTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        String hostAddress = ip.getHostAddress();
        String hostname = ip.getHostName();
        System.out.println(String.format("address : %s, hostname : %s", hostAddress, hostname));
    }
}
