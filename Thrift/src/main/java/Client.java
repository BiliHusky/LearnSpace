import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by yjw on 18-8-29.
 */
public class Client {
    public static void main(String[] args) throws TException {
        TSocket socket = new TSocket("127.0.0.1", 9090);
        socket.setTimeout(3000);
        TTransport transport = new TFramedTransport(socket);
        TProtocol protocol = new TCompactProtocol(transport);
        transport.open();
        System.out.println("Connected to Thrfit Server");

        DemoService.Client client = new DemoService.Client.Factory()
                .getClient(protocol);
        String result = client.sayHi("ITer_ZC");
        System.out.println(result);
    }
}
