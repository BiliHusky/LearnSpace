package cglibproxy;

/**
 * Created by yjw on 18-9-13.
 */

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(obj, args);
        PerformanceMonitor.end();
        return result;
    }
}
