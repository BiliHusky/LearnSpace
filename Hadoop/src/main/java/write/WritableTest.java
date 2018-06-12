package write;

import org.apache.hadoop.io.Writable;

import java.io.*;

/**
 * Created by yjw on 18-3-8.
 */
public class WritableTest {
    public static void main(String[] args) {

    }

    /**
     * this is an example that wraps a java.io.ByteArrayOutputStream in  a
     * java.io.DataOutputStream(an implementation of java.io.DataOutput) to
     * capture the bytes in serialized stream
     */
    public static byte[] serialize(Writable writable) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);
        writable.write(dataOut);
        dataOut.close();
        return out.toByteArray();
    }

    /**
     * this is an example to deserialize the bytes
     */
    public static byte[] deserialize(Writable writable, byte[] bytes) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        DataInputStream dataIn = new DataInputStream(in);
        writable.readFields(dataIn);
        dataIn.close();
        return bytes;
    }
}
