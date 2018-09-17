package advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjw on 18-9-17.
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }


    public boolean matches(Method method, Class<?> aClass, Object[] objects) {
        System.out.println("invoke matches(method, clazz) " + aClass.getName() + "." + method.getName() + " dynamic check");
        String clientName = (String) objects[0];
        return specialClientList.contains(clientName);
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> aClass) {
                System.out.println("invoke getclassfilter() to " + aClass.getName() + " check for static method");
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("invoke matches " + targetClass.getName() + "." + method.getName() + "checkout staic.");
        return "greetTo".equals(method.getName());
    }
}
