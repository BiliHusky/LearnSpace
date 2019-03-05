package annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yjw on 18-10-12.
 */


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default "unknown";
}

class Person {
    @MyAnnotation
    @Deprecated
    public void empty() {
        System.out.println("empty");
    }

    @MyAnnotation(value = {"girl", "boy"})
    public void somebody(String name, int age) {
        System.out.println("somebody " + name + " ," + age);
    }
}

public class AnnotationTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        Class<Person> c = Person.class;
        Method msomebody = c.getMethod("somebody", new Class[]{String.class, int.class});
        msomebody.invoke(person, new Object[]{"lily", 18});
        iteratorAnnotation(msomebody);
        Method mEmpty = c.getMethod("empty", new Class[] {});
        mEmpty.invoke(person, new Object[]{});
        iteratorAnnotation(mEmpty);
    }

    public static void iteratorAnnotation(Method method) {
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            String[] values = myAnnotation.value();
            for (String v : values) {
                System.out.printf(v + ",");
            }
            System.out.println();
        }

        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
