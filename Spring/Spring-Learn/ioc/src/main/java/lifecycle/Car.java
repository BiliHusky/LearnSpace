package lifecycle;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by yjw on 18-8-27.
 */
public class Car implements BeanFactoryAware , BeanNameAware, InitializingBean, DisposableBean
{
    private String brand;
    private String color;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("car constructor");
    }
    public String getColor() {
        return color;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void introduce() {
        System.out.println("brand : " + brand + "; color:" + color + "; maxSpeed:" + maxSpeed);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware->setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String s) {
        System.out.println("BeanNameAware->setBeanName()");
        this.beanName = beanName;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("initializingBean->afterPropertiesSet()");
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()");
    }

    public void myInit() {
        System.out.println("init-method myInit ,set maxSpeed = 240");
        this.maxSpeed = 240;
    }

    public void myDestroy() {
        System.out.println("destroy-method myDestroy()");
    }

    public void setColor(String color) {
        this.color = color;
    }
}
