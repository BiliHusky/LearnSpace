package com.yjw.interview.alg.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author David Yang
 * @date 2020-02-01 14:04
 */
public class TestUtil {

    @Test
    public void who_is_thief() {
        for (int x = 0; x < 4; x++) {
            int dis_a = (x != 0) ? 1 : 0;
            int dis_b = (x == 2) ? 1 : 0;
            int dis_c = (x == 3) ? 1 : 0;
            int dis_d = 1 - dis_c;

            if ((dis_a + dis_b + dis_c + dis_d) == 3) {
                char thief = (char) ((int) 'A' + x);
                System.out.println("thief is " + thief);
                break;
            }
        }
    }

    @Test
    public void testString() {
        String str = new String("laowang");
        change(str);
        System.out.println(str);
    }

    public void change(String str) {
        str = new String("xiaowang");
    }

    @Test
    public void testInteger() {
        Integer i = new Integer(3333);
        changeI(i);
        System.out.println(i);
    }

    public void changeI(Integer i) {
        i = new Integer(4444);
    }

    @Test
    public void testI() {
        int i = 0;
        i = i++;
        System.out.println(i);
    }

    @Test
    public void testSwitch() {
        String a = new String("abc");
        switch (a) {
            case "abc":
                System.out.println("omg");
                break;
        }
    }

    @Test
    public void testLocalTime_LocalDate_LocalDateTime() {
        /* 获取时间 */
        System.out.println("获取时间");
        // 获取日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);    // output:2019-08-16
        // 获取时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);    // output:21:09:13.708
        // 获取日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);    // output:2019-08-16T21:09:13.708

        System.out.println();

        /*获取时间戳*/
        System.out.println("获取时间戳");
        long milli = Instant.now().toEpochMilli(); // 获取当前时间戳（精确到毫秒）
        long second = Instant.now().getEpochSecond(); // 获取当前时间戳（精确到秒）
        System.out.println(milli);  // output:1565932435792
        System.out.println(second); // output:1565932435
        System.out.println();

        /*时间格式化*/
        // 时间格式化①
        System.out.println("时间格式化");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeFormat = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(timeFormat);  // output:2019-08-16 21:15:43
        // 时间格式化②
        String timeFormat2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeFormat2);    // output:2019-08-16 21:17:48
        System.out.println();

        /*时间转换*/
        System.out.println("时间转换");
        String timeStr = "2019-10-10 06:06:06";
        LocalDateTime dateTime = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime);
        System.out.println();

        /*获得昨天这个时刻*/
        System.out.println("获得昨天这个时间");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.plusDays(-1);
        System.out.println(yesterday);

    }

    //获取本月最后一天
    @Test
    public void test0001() {
        Calendar clr = Calendar.getInstance();
        clr.set(Calendar.DAY_OF_MONTH, clr.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println(clr.getTime());
        System.out.println();

        LocalDate today = LocalDate.now();
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));
    }

    //时间
    @Test
    public void test0002() {
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }

    //计算时间相隔时间
    @Test
    public void test0003() {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = dt1.plusSeconds(60);
        Duration duration = Duration.between(dt1, dt2);
        System.out.println(duration.getSeconds());  // output:60
    }

    //计算两个日期的相隔日期
    @Test
    public void test0004() {
        LocalDate d1 = LocalDate.now();
        LocalDate d2 = d1.plusDays(2);
        Period period = Period.between(d1, d2);
        System.out.println(period.getDays());   //output:2
    }

    //foreach 的空指针
    @Test
    public void test0005() {
        List<String> stringList = new LinkedList<>();
        for (String elem : stringList) {
            System.out.println(elem);
        }
        System.out.println("finish empty");
        List<String> strNullList = null;
        for (String elem : strNullList) {
            System.out.println(elem);
        }
        System.out.println("finishnull");
    }

    // Arrays.copy
    @Test
    public void test0006() {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        arr1[1] = 5;
        for (Integer elem : arr1) {
            System.out.println(elem);
        }
        System.out.println();
        for (Integer elem : arr2) {
            System.out.println(elem);
        }
    }

    //数据合并
    @Test
    public void test0007() {
        int[] arr = {2, 8, 13, 11, 6, 7};
        int[] arr2 = {66, 88};
        // 合并数组
        int[] arr3 = org.apache.commons.lang3.ArrayUtils.addAll(arr, arr2);
        System.out.println(Arrays.toString(arr3));
    }

    //数组排序
    @Test
    public void test0008() {
        int[] arr = {2, 8, 13, 11, 6, 7};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //数组反转
    @Test
    public void test0009() {
        int[] arr = {2, 8, 13, 11, 6, 7};
        // 数组正序（排序）
        Arrays.sort(arr);
        // 数组逆序
        org.apache.commons.lang3.ArrayUtils.reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 数组元素查着
    @Test
    public void test0010() {
        int[] arr = {1, 3, 4, 5};
        // Arrays.binarySearch() 使用二分法查询某值
        int index = Arrays.binarySearch(arr, 5);
        System.out.println(index);
    }

    //数组转字符串
    @Test
    public void test0011() {
        String[] arr = {"laowang", "stone", "wanglei"};
        String str = Arrays.toString(arr);
        System.out.println(str);
    }

    //数组转换成字符串 12-14
    @Test
    public void test0012() {
        String[] arr = {"laowang", "stone", "wanglei"};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1)
                sb.append(",");
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test0013() {
        String[] arr = {"laowang", "stone", "wanglei"};
        String str2 = Arrays.toString(arr);
        System.out.println(str2);
    }

    @Test
    public void test0014() {
        String[] arr = {"laowang", "stone", "wanglei"};
        String str3 = StringUtils.join(Arrays.asList(arr), ","); // 使用英文逗号分隔
        System.out.println(str3);
    }

    //测试binarySearch
    @Test
    public void test0015() {
        String[] arr = {"dog", "cat", "pig", "bird"};
//        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int result = Arrays.binarySearch(arr, "bird");
        System.out.println(result == -1);

        String[] arr2 = {"bird", "cat", "dog", "pig"};
        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        int result2 = Arrays.binarySearch(arr2, "bird");
        System.out.println(result2 == -1);
    }

    //Arrays.fill测试
    @Test
    public void test0016() {
        int[] arrInt = new int[10];
        Arrays.fill(arrInt, 2, 5, 6);
        System.out.println(Arrays.toString(arrInt));
    }

    //测试类加载
    @Test
    public void test0017() {
        B a = new B();
//        a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        a.m(a);
        a.m(b);
        a.m(c);
        a.m(d);
    }

    //测试接口 默认接口
    @Test
    public void test0018() {
        IAnimal animal = new AnimalImpl();
        animal.sayHi();
        animal.saygoodbye();
    }

    //迭代器测试
    @Test
    public void test0019() {
        List<String> list1 = new LinkedList<>();
//        list = null;
        Iterator itr = list1.iterator();
        while (itr.hasNext()) {
            System.out.println("omg");
        }

        List<String> list = new ArrayList<String>() {{
            add("Java");
            add("Java虚拟机");
            add("Java中文社群");
        }};
        Iterator iterator = list.iterator();
// 遍历
        while (iterator.hasNext()) {
            String str = (String) iterator.next();
            if (str.equals("Java虚拟机")) {
                iterator.remove();
            }
        }
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(list);
    }

    //线程
    @Test
    public void test0020() throws InterruptedException {
        Thread joinThread = new Thread(() -> {
            try {
                System.out.println("执行前");
                Thread.sleep(1000);
                System.out.println("执行后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });
        joinThread.start();
        joinThread.join();
        System.out.println("主程序");
    }

    //线程池
    @Test
    public void test0021() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2),
                new ThreadPoolExecutor.DiscardPolicy());
        threadPool.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 打印线程名称
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //线程池
    @Test
    public void test0022() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(() -> {
                System.out.println(System.currentTimeMillis());
                System.out.println("CurrentTime - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}

class ImpTest implements fun1, fun2 {

    @Override
    public void m() {

    }
}

interface fun1 {
    void m();
}

interface fun2 {
    void m();
}
class A {
    public void m(A a) {
        System.out.println("AA");
    }
    public void m(D d) {
        System.out.println("AD");
    }
}
class B extends A {
    @Override
    public void m(A a) {
        System.out.println("BA");
    }
    public void m(B b) {
        System.out.println("BD");
    }
}
class C extends B{}
class D extends B{}

class Outer {
    private String out;

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
        Inner in = new Inner();
        in.inn = "";
    }

    private class Inner {
        private String inn;

        public String getInn() {
            return inn;
        }

        public void setInn(String inn) {
            this.inn = inn;
            Outer.this.out="";
        }
    }
}

interface IAnimal {
    static String animalName = "Animal Name";
    static void printSex() {
        System.out.println("Male Dog");
    }
    default void sayHi() {
        System.out.println("hello org");
    }

    void saygoodbye();
}
class AnimalImpl implements IAnimal {
    public void saygoodbye() {
        System.out.println("good bye");
    }

    public void sayHi() {
        System.out.println("hello imp");
    }
}

interface IAnimal1 {
    static String animalName = "Animal Name";
}
class AnimalImpl1 implements IAnimal1 {
    static String animalName = new String("Animal Name1");
    public static void main(String[] args) {
        System.out.println(IAnimal.animalName == animalName);
    }
}

class Person {
    private Integer age;
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Person)) {
            return false;
        } else {
            return this.getAge().equals(((Person) o).getAge());
        }
    }
    public int hashCode() {
        return age.hashCode();
    }
    public Person(int age) {
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    public static void main(String[] args) {
        HashMap<Person, Integer> hashMap = new HashMap<>();
        Person person = new Person(18);
        hashMap.put(person, 1);
        System.out.println(hashMap.get(new Person(18)));
    }
}