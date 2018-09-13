package archtecture.keywords;


import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by yjw on 18-8-30.
 */
public class StringTest {
    public static void main(String[] args) {
        String p1 = "1";
        String p2 = "2";
        String p3 = "3";
        String res = String.format("%s + %s = %s", p1,p2,p3);
        System.out.println(res);


        Date  td = new Date(1482302414479L);
        System.out.println(td.toString());
        Date  td2 = new Date(1527782400000L);
        System.out.println(td2.toString());
        System.out.println(td2.after(td));
        Timestamp timeStamp =  new Timestamp(System.currentTimeMillis());
        String ts = "2018-06-01 00:00:00";
        timeStamp = Timestamp.valueOf(ts);
        System.out.println(timeStamp);
        System.out.println(timeStamp.getTime());
    }
}
