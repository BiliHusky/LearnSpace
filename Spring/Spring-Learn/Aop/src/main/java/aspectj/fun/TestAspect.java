package aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by yjw on 18-9-18.
 */
@Aspect
public class TestAspect {
    @AfterReturning("@annotation(anno.NeedTest)")
    public void needTestFun() {
        System.out.println("needTestFun() executed ");
    }

    @AfterReturning("this(aspectj.Seller)")
    public void thisTest() {
        System.out.println("thisTest() executed");
    }
}
