package ch1;

/**
 * Created by yjw on 18-3-29.
 */
public class MallardDuck extends Duck {

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}
