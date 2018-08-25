package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reflect.Car;

/**
 * Created by yjw on 18-8-24.
 */

@Configuration
public class Beans {

    @Bean(name="car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("RR");
        car.setMaxSpeed(350);
        return car;
    }
}
