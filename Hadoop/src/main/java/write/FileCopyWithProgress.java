package write;

import org.apache.hadoop.conf.Configuration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by yjw on 18-3-5.
 */
public class FileCopyWithProgress {
   public static void main(String[] args) throws FileNotFoundException {
       FileOutputStream out = new FileOutputStream("test");
   }
}
