import java.util.Map;

/**
 * Created by yjw on 18-9-18.
 */
public class TestBool {
    public static void main(String[] args) {
        Object bool = null;
        boolean res = false;
        if ("false".equalsIgnoreCase(String.valueOf(bool)) || "true".equalsIgnoreCase(String.valueOf(bool))) {
            res = Boolean.valueOf(String.valueOf(bool));
        } else {
            res = true;
        }
        System.out.println(res);
    }
}
