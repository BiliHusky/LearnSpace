/**
 * @author David Yang
 * @date 2019-12-04 17:38
 */
public class AutoBuild{

    private int a;


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static AutoBuild valueOf(int i) {
        AutoBuild result = new AutoBuild();
        result.setA(i);
        return result;
    }

    public static void main(String[] args) {

    }
}
