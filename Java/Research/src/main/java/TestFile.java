import java.io.File;

/**
 * Created by yjw on 18-5-18.
 */
public class TestFile {
    public static void main(String[] args) {
        File root = new File("/home/yjw/Learn");
        System.out.println(new File(root, "current"));
    }
}
