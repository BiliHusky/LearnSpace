package advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by yjw on 18-9-14.
 */
public class TransactionManager implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("-----------------------");
        System.out.println("method :" + method.getName());
        System.out.println("throw exception : " + ex.getMessage());
        System.out.println("success roll back");
    }
}
