package advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by yjw on 18-9-13.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object o) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("How are you ! Mr." + clientName);
    }
}
