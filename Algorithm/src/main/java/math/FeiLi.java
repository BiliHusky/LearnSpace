package math;

/**
 * Created by yjw on 18-9-27.
 */

/**
 * ax+by=d get x, y & beglong to Z
 */
public class FeiLi {
    public static void main(String[] args) {
        int x=0,y=0;
        //// TODO: 18-9-27
    }
    
    public static int exgcd(int a, int b, int x, int y) {
        if (b==0){
            x = 1;
            y = 0;
            return a;
        }
        
        int g = exgcd(b, a%b, x, y);
        int t = x;
        x = y;
        y = t - a / b * y;
        System.out.println("x :" + x + " y:" + y);
        return g;
    }
}
