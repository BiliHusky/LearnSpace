import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yjw on 19-3-4.
 */
public class PropertiesRead {

    public static void main(String[] args) throws IOException {
        String name = "yjw";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        System.out.println("read from :" + name + ".properties");
        InputStream in = loader.getResourceAsStream(name + ".properties");
        properties.load(in);
        in.close();
        System.out.println(properties.getProperty(name + ".version"));
        System.out.println(properties.getProperty(name + ".heart"));

    }
}
