package or;

import org.apache.log4j.Logger;

public class T {
    private static Logger log = Logger.getLogger(T.class.getClass());
    public static void main(String[] args) {
        log.info("test");
        tt t = new tt();
        try {
            t.print();
        } catch (IndexOutOfBoundsException e) {
            //e.printStackTrace();
            log.error("error message:", e);
        }
    }
}

class tt {
    private static Logger log = Logger.getLogger(tt.class.getClass());

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void print() {
        int a =1 ;
        for (int i =9 ; i>a ; i--) {
            log.info("print I:" + i);
        }
        throw new IndexOutOfBoundsException("unknow index");
    }
}
