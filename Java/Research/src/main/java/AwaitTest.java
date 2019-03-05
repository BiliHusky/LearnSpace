/**
 * Created by yjw on 18-12-25.
 */
public class AwaitTest {
    private static Integer a = 1;

     static class A implements Runnable{
         private Integer b;

         public A(Integer b) {
             this.b = b;
         }

        @Override
        public void run() {
            synchronized (a) {
                while (a < 10) {
                    synchronized (a) {
                        while (b < a) {
                            try {
                                a.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(b);
                        a = b;
                        a.notifyAll();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TestFactory t1 = TestFactory.generate("");
        TestFactory t2 = TestFactory.generate("");
        System.out.println("t1.name:"+ t1.getName() + "  t2.name:" + t2.getName());
        t1.setName("haha");
        System.out.println("t1.name:"+ t1.getName() + "  t2.name:" + t2.getName());
        Boolean a = true;

    }
}

class TestFactory {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestFactory getEmpty() {
        return empty;
    }

//    public void setEmpty(TestFactory empty) {
//        this.empty = empty;
//    }

    private String name;

    private static final TestFactory empty = new TestFactory("empty");

    public TestFactory(String name) {
        this.name = name;
    }

    public static TestFactory generate(String name) {
        return name.trim().isEmpty() ? empty : new TestFactory(name);
    }
}
