package lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by yjw on 18-8-27.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //return null;
        if (beanName.equals("car")) {
            Car car = (Car)bean;
            if (car.getColor() == null) {
                System.out.println("BeanPostProcessor.postProcessBeforeInitialization(), color is null and set black");
                car.setColor("black");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("car")) {
            Car car = (Car)bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("BeanPostProcessor.postProcessAfterInitialization, set maxSpeed to 200");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
