package context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import reflect.Car;

import static org.testng.Assert.*;

/**
 * Created by yjw on 18-8-24.
 */
public class AnnotationApplicationContextTest {

    @Test
    public void getBean() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car  = ctx.getBean("car", Car.class);
        assertNotNull(car);
    }
}
