package archtecture.threadsafe;

/**
 * Created by yjw on 18-6-7.
 */

import java.util.*;

/***
 * link http://www.codejava.net/java-core/collections/understanding-collections-and-thread-safety-in-java
 *
 *
 * this test program illustrates how a collection's iterator fails fast
 * and throw ConcurrentModificationException
 */
public class IteratorFailFastTest {
    private List<Integer> list = new ArrayList<>();

    public IteratorFailFastTest() {
        for (int i=0; i< 10_000; i++) {
            list.add(i);
        }
    }

    public void runUpdateThread() {
        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=10_000; i<20_000_000_00; i++) {
                    list.add(i);
                }
            }
        });
        thread_1.start();
    }

    public void runIteratorThread() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> iterator = list.listIterator();
                while (iterator.hasNext()) {
                    Integer number = iterator.next();
                    System.out.println(number);
                }
            }
        });
        thread2.start();
    }

    public static void main(String[] args) {
        IteratorFailFastTest test = new IteratorFailFastTest();
        test.runIteratorThread();
        test.runUpdateThread();

    }
}
