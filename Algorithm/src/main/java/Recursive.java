/**
 * Created by yjw on 18-5-18.
 */
public class Recursive {

    public int getSum(int a) {
        if ( a == 1)
            return a;
        else
            return getSum(a-1)+a;
    }

    public static void main(String[] args) {
        Recursive a = new Recursive();
        System.out.println(a.getSum(4));
    }
}
