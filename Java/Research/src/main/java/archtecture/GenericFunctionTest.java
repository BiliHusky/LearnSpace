package archtecture;

/**
 * Created by yjw on 18-9-7.
 */
public class GenericFunctionTest {
    public static <T> T getMiddle(T[] a) {
        return a[a.length/2];
    }

    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T smallest = a[0];
        for (int i=1; i<a.length;i++) {
            if (smallest.compareTo(a[i])>0) {
                smallest=a[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        Integer[] test ={1,2,3,4,5};
        System.out.println(GenericFunctionTest.<Integer>getMiddle(test));
        System.out.println();
        System.out.println("test comparable");
        Person1 p11 = new Person1();
        p11.setX(1);p11.setY(1);p11.setZ(1);
        Person1 p12 = new Person1();
        p12.setX(2);p12.setY(2);p12.setZ(2);
        Person1[] p1s = new Person1[] {p11, p12};
        System.out.println(GenericFunctionTest.<Integer>min(test));
        //System.out.println(GenericFunctionTest.<Person1>min(p1s));
    }
}
