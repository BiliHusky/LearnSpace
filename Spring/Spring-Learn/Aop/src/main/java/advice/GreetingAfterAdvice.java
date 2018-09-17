package advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by yjw on 18-9-14.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnobj, Method method, Object[] args, Object obj) throws Throwable {
        System.out.println("Please enjoy yourself");
    }
}
