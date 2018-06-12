package read;

/**
 * Created by yjw on 18-3-5.
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;

/**
 * FSDataInputStream : This class is specialization of java.io.DataInputStream with suppot for random access,
 * you can read from any part of the stream
 */
public class TestFSDataInputStream {
    public static void main(String[] args) throws IOException {


        String url = "hdfs://192.168.130.100/tmp/oozieTest.csv";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(url), conf);
        FSDataInputStream in = null;
        try {
            in = fs.open(new Path(url));
            IOUtils.copyBytes(in, System.out, 4096, false);
            in.seek(0);
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }

    }
}
