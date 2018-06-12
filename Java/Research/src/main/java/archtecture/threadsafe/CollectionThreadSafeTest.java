package archtecture.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by yjw on 18-6-7.
 */
public class CollectionThreadSafeTest {
    public void testVector() {
        long startTime = System.currentTimeMillis();
        Vector<Integer> vector = new Vector<Integer>();
        for (int i=0; i< 10_000_000; i++) {
            vector.addElement(i);
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Test vector :" + totalTime + " ms");
    }

    public void testArrayList() {
        long startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i< 10_000_000; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Test Arraylist :" + totalTime + " ms");
    }

    public static void main(String[] args) {
        CollectionThreadSafeTest test = new CollectionThreadSafeTest();//test.testArrayList();
        test.testVector();

    }
}
