package archtecture.datastructure;

import java.io.File;

/**
 * Created by yjw on 18-9-6.
 */
public class FIle {
    public static void main(String[] args ){
        File test = new File("/home/yjw/tmp/empty");
        File[] t = test.listFiles();
        if ((new File("/home/yjw/tmp/empty").listFiles()).length == 0) {
            System.out.println("h");
        }
        System.out.println("test");
    }
}
