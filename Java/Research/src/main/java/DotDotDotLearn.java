import java.util.LinkedList;
import java.util.List;

/**
 * Created by yjw on 19-3-5.
 */
public class DotDotDotLearn {
    private String id;
    private List<String> list;
    public DotDotDotLearn(String id, String... args) {
        this.id = id;
        list = new LinkedList<>();
        for (int i = 0; i<args.length; i++) {
            list.add(args[i]);
        }
    }

    @Override
    public String toString() {
        return "DotDotDotLearn{" +
                "id='" + id + '\'' +
                ", list size=" + list.size() +
                '}';
    }

    public static void main(String[] args) {
        DotDotDotLearn dt = new DotDotDotLearn("id", "1", "2", "3");
        System.out.println(dt.toString());
    }
}
