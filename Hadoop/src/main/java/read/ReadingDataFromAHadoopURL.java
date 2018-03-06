package read;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * not summary: 1.java.net.MalformedURLException: unknown protocol: hdfs  ？
 *                需要检查maven中是否加入了hadoop-hdfs这个artfict
 */

/**
 * Created by yjw on 18-3-5.
 */
public class ReadingDataFromAHadoopURL {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) {

        InputStream in = null;
        try {
            in = new URL("hdfs://192.168.130.100/tmp/oozieTest.csv").openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
