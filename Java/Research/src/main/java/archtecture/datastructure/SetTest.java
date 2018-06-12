package archtecture.datastructure;

import java.util.*;

/**
 * Created by yjw on 18-6-8.
 */
public class SetTest {
    public static void testHashSet(){
        Set hashset = new HashSet();
        Person p1 = new Person("david", 11);
        Person p2 = new Person("peter" , 12);
        Person p3 = new Person("david", 11);
        hashset.add(p1);hashset.add(p2);hashset.add(p3);
        Iterator it = hashset.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Set hashset2 = new HashSet();
        Person2 t1 = new Person2("david", 11);
        Person2 t2 = new Person2("peter" , 12);
        Person2 t3 = new Person2("david", 11);
        hashset2.add(t1);hashset2.add(t2);hashset2.add(t3);
        Iterator it2 = hashset2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }

    public static void testTreeSetWithCompareble() {
        TreeSet ts = new TreeSet();
        ts.add("cc");
        ts.add("dd");
        ts.add("aa");
        ts.add("bb");
        System.out.println(ts);
        TreeSet ts2 = new TreeSet();
        ts2.add(new Person3("aa", 20, "male"));
        ts2.add(new Person3("bb", 18, "male"));
        ts2.add(new Person3("dd", 17, "male"));
        ts2.add(new Person3("cc", 15, "male"));
        ts2.add(new Person3("dd", 17, "male"));
        System.out.println(ts2);
    }

    public static void testTreeSetWithComparator() {
        TreeSet ts = new TreeSet(new MyComparator());
        ts.add(new Book("book1", 100));
        ts.add(new Book("b2", 75));
        ts.add(new Book("bb", 130));
        System.out.println(ts);
    }

    public static void main(String[] args) {
        //testHashSet();
        //testTreeSetWithCompareble();
        testTreeSetWithComparator();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "name:" + name + " age:" + age;
    }
}

class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + name + " age:" + age + " hashcode:" + this.hashCode();
    }

    @Override
    public int hashCode() {
        int res = 0;
        char[] cs = name.toCharArray();
        for(int i = 0 ; i < cs.length; i++) {
            res += i*Integer.valueOf(cs[i]);
        }

        return res + age;
    }

    @Override
    public boolean equals(Object obj) {
        Person2 person = (Person2)obj;
        return this.name == person.getName() ? (this.age == person.getAge() ? true : false) : false;
    }
}

class Person3 implements Comparable {
    private String name;
    private int age;
    private String gender;

    public Person3(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public int compareTo(Object o) {
        Person3 p = (Person3) o;
        if (this.age > p.age) {
            return 1;
        }
        if (this.age < p.age) {
            return -1;
        }

        return this.name.compareTo(p.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age*37;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person3)) {
            return false;
        }
        Person3 p = (Person3) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age" + age + ", gender=" + gender + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;
        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        }
        if (b1.getPrice() < b2.getPrice()) {
            return -1;
        }

        return b1.getName().compareTo(b2.getName());
    }
}
class Book {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Book [name=" + name + ", price=" + price + "]";
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}