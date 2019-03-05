package ch3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yjw on 19-1-22.
 */
public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    private volatile int hashCode;

    public PhoneNumber(int areacode, int prefix, int lineNumber) {
        this.areaCode = (short) areacode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
        }
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        m.put(new PhoneNumber(100,200,300), "jenny");
        System.out.println(m.get(new PhoneNumber(100, 200, 300)));
    }
}
