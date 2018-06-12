package mapreduce;

/**
 * Created by yjw on 18-3-9.
 */


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Tool;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ConfigurationTest extends Configured implements Tool {
    Configuration conf = new Configuration();

    static {
        Configuration.addDefaultResource("Hadoop/src/main/resources/HadoopConf/hadoop-conf/hdfs-site.xml");
        Configuration.addDefaultResource("Hadoop/src/main/resources/HadoopConf/hadoop-conf/core-site.xml");
        Configuration.addDefaultResource("Hadoop/src/main/resources/HadoopConf/yarn-conf/core-site.xml");
        Configuration.addDefaultResource("Hadoop/src/main/resources/HadoopConf/yarn-conf/hdfs-site.xml");
        Configuration.addDefaultResource("Hadoop/src/main/resources/HadoopConf/yarn-conf/mapred-site.xml");
        Configuration.addDefaultResource("Hadoop/src/main/resources/HadoopConf/yarn-conf/yarn-site.xml");
    }

    public static void main(String[] args) throws IOException {
        ConfigurationTest t = new ConfigurationTest();
        Configuration conf = t.getConfiguration();
        FileSystem fs = FileSystem.get(conf);
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : fileStatuses) {
            System.out.println(fileStatus.getPath().toString());
        }
    }

    public Configuration getConfiguration() {
        conf.addResource(new Path("Hadoop/src/main/resources/HadoopConf/hadoop-conf/hdfs-site.xml"));
        conf.addResource(new Path("Hadoop/src/main/resources/HadoopConf/hadoop-conf/core-site.xml"));
        conf.addResource(new Path("Hadoop/src/main/resources/HadoopConf/yarn-conf/core-site.xml"));
        conf.addResource(new Path("Hadoop/src/main/resources/HadoopConf/yarn-conf/hdfs-site.xml"));
        conf.addResource(new Path("Hadoop/src/main/resources/HadoopConf/yarn-conf/mapred-site.xml"));
        conf.addResource(new Path("Hadoop/src/main/resources/HadoopConf/yarn-conf/yarn-site.xml"));
        return conf;
    }
    @Override
    public int run(String[] strings) throws Exception {
        conf = getConf();
        for (Map.Entry<String, String> entry : conf) {
            System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
        }
        return 0;
    }
}
