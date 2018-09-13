import org.apache.thrift.TException;

/**
 * Created by yjw on 18-8-29.
 */
public class DemoServiceImpl implements DemoService.Iface{

    private String serveId;

    public DemoServiceImpl(String serveId) {
        this.serveId = serveId;
    }

    public String sayHi(String name) throws TException {
        return "Hi " + this.serveId + ", from Server";
    }

    public String getServeId() {
        return serveId;
    }

    public void setServeId(String serveId) {
        this.serveId = serveId;
    }
}
