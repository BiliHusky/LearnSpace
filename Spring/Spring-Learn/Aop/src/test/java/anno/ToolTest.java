package anno;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by yjw on 18-9-17.
 */
public class ToolTest {
    @Test
    public void tool() {
        Class clazz = ForumService.class;

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "() need test");
                } else {
                    System.out.println(method.getName() + "() don't need test");
                }
            }
        }
    }
}
