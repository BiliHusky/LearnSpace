package com.yjw.interview.alg.knowledge;

import java.io.*;
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        System.out.println(Math.round(-1.5));
        testMap();
       // testQueue();
        //testListLock();

        System.out.println("test serialize");
        TestSerializable.writeObject("");
        TestSerializable.Person person = TestSerializable.readObject("");
        TestSerializable.Person person1 = testTryCatchFinally();

        int a = 1;
        int b = a;
        while (++a > 0) {
            b = a;
        }
        System.out.println(b);
        testShort();
        Integer v = 1000;
        System.out.println(String.valueOf(v));
        System.out.println("finish");
    }

    private static void testShort() {
        Set<Short> set = new HashSet<Short>();
        for (short i = 0; i < 5; i++) {
            set.add(i);
            set.remove((i-1));
        }
        System.out.println(set.size());
    }

    private static TestSerializable.Person testTryCatchFinally() {
        TestSerializable.Person person = null;
        try {
            person = new TestSerializable.Person("abc", 1);
            throw new Exception("omg");
        } catch (Exception e) {
            return person;
        } finally {
            System.out.println("run finally");
            person.setName("omg");
        }

    }


    private static void testListLock() {
        List<String> list = new ArrayList<String>();
        list.add("x");
        Collection<String> clist = Collections.unmodifiableCollection(list);
        clist.add("y");
        System.out.println("size:" + list.size());
    }

    private static void testQueue() {
        Queue<String> queue = new LinkedList<String>();
        //queue. offer("string"); // add
        System. out. println(queue. poll());
        System. out. println(queue. remove());
        System. out. println(queue. size());
    }

    private static void testMap() {
        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        for (int i=25; i>=0; i--) {
            hashmap.put(String.valueOf((char)(i+97)), i);
        }

        Map<String, Integer> treemap = new TreeMap<String, Integer>();
        for (int i=25; i>=0; i--) {
            treemap.put(String.valueOf((char)(i+97)), i);
        }

        Iterator<String> itr = hashmap.keySet().iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        Iterator<String> itr2 = treemap.keySet().iterator();
        while (itr2.hasNext()) {
            System.out.print(itr2.next() + " ");
            itr2.remove();
        }
        System.out.println();
        System.out.println(treemap.size());
    }
}

class Test2 extends Thread {
   
}


class TestSerializable {
    static class Person implements Serializable {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void writeObject(String file) {
        if (file == null || file.trim().isEmpty()) {
            file = "person.txt";
        }
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
            Person person = new Person("david", 100);
            outputStream.writeObject(person);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Person readObject(String file) {
        if (file == null || file.trim().isEmpty()) {
            file = "person.txt";
        }
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            Person person = (Person) inputStream.readObject();
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}