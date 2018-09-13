package archtecture;

/**
 * Created by yjw on 18-9-7.
 */
public class GenericTest {
    public static void main(String[] args) {
        System.out.println("Person1 ");
        Person1 person1 = new Person1();
        person1.setX(20);
        person1.setY(20.2);
        person1.setZ("p1");
        int x = (int) person1.getX();
        double y = (double) person1.getY();
        String z = (String) person1.getZ();
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println();

        System.out.println("Person2<T>");
        Person2 person2 = new Person2();
        person2.setX(20);
        person2.setY(20.2);
        person2.setZ("p2");
        System.out.println(person2.getX());
        System.out.println(person2.getY());
        System.out.println(person2.getZ());
        System.out.println();

        System.out.println("Person3<T1, T2>");
        Person3<String, Integer> person3 = new Person3<>();
        person3.setX("zi");
        person3.setY(1);
        System.out.println(person3.getX());
        System.out.println(person3.getY());
        System.out.println();

        System.out.println("Boy<T1,T2,T3> extends Person3<T1, T2>");
        Boy<String, Integer, Double> boy = new Boy<>();
        boy.setX("string");
        boy.setY(11);
        boy.setZ(22.2);
        System.out.println(boy.getX());
        System.out.println(boy.getY());
        System.out.println(boy.getZ());
        System.out.println();

        System.out.println("Boy1<T1, T2, T3> implements Person4<T1, T2>");
        Boy2<String, Integer, Double> boy2 = new Boy2<>();
        boy2.setX("string");
        boy2.setY(1212);
        boy2.setZ(22.2);
        System.out.println(boy2.getX());
        System.out.println(boy2.getY());
        System.out.println(boy2.getZ());
        System.out.println();
    }
}

class Person1 {
    private Object x;
    private Object y;
    private Object z;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }

    public Object getY() {
        return y;
    }

    public void setY(Object y) {
        this.y = y;
    }

    public Object getZ() {
        return z;
    }

    public void setZ(Object z) {
        this.z = z;
    }
}

class Person2<T> {
    private T x;
    private T y;
    private T z;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getZ() {
        return z;
    }

    public void setZ(T z) {
        this.z = z;
    }
}

class Person3<T1, T2> {
    private T1 x;
    private T2 y;

    public T1 getX() {
        return x;
    }

    public void setX(T1 x) {
        this.x = x;
    }

    public T2 getY() {
        return y;
    }

    public void setY(T2 y) {
        this.y = y;
    }
}

class Boy<T1, T2, T3> extends Person3<T1, T2> {
    private T3 z;

    public T3 getZ() {
        return z;
    }

    public void setZ(T3 z) {
        this.z = z;
    }
}


interface Person4<T1, T2> {
    public T1 getX();
    public T2 getY();
}

class Boy2<T1, T2, T3> implements Person4<T1, T2> {
    private T1 x;
    private T2 y;
    private T3 z;

    @Override
    public T1 getX() {
        return x;
    }

    @Override
    public T2 getY() {
        return y;
    }

    public T3 getZ() {
        return z;
    }

    public void setZ(T3 z) {
        this.z = z;
    }

    public void setX(T1 x) {
        this.x = x;
    }

    public void setY(T2 y) {
        this.y = y;
    }
}