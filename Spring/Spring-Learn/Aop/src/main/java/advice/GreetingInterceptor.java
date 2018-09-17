package advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by yjw on 18-9-14.
 */
public class GreetingInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("how are you miss " + clientName);
        Object obj = methodInvocation.proceed();
        System.out.println("enjoy yourself");
        return obj;
    }
}
