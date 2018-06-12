package write;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;

/**
 * Created by yjw on 18-3-7.
 */

/**
 *      Hadoop Compression Codecs
 *      DEFLATE     org.apache.hadoop.io.compress.DefaultCodec
 *      gzip        org.apache.hadoop.io.compress.GzipCodec
 *      bzip2       org.apache.hadoop.io.compress.BZip2Codec
 *      LZO         com.hadoop.compression.lzo.lzopCodec
 *      LZ4         org.apache.hadoop.io.compress.Lz4Codec
 *      Snappy      org.apache.hadoop.io.compress.SnappyCodec
 */
public class StreamCompressor {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String codecClassname = args[0] ;
        Class<?> codecClass = Class.forName(codecClassname);
        Configuration conf = new Configuration();
        CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, conf);
        CompressionOutputStream out = codec.createOutputStream(System.out);
        IOUtils.copyBytes(System.in, out, 4096, false);
    }
}
