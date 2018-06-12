package write;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by yjw on 18-3-8.
 */
public class EX_TextPar implements WritableComparable<EX_TextPar> {
    private Text first;
    private Text second;

    public EX_TextPar() {
        set(new Text(), new Text());
    }

    public EX_TextPar(String first, String second) {
        set(new Text(first), new Text(second));
    }

    public EX_TextPar(Text first, Text second) {
        set(first, second);
    }

    public void set(Text first, Text second) {
        this.first = first;
        this.second = second;
    }

    public Text getFirst() {
        return first;
    }

    public Text getSecond() {
        return second;
    }

    public int compareTo(EX_TextPar o) {
        int cmp = first.compareTo(o.first);
        if (cmp != 0) {
            return cmp;
        }
        return second.compareTo(o.second);
    }

    public void write(DataOutput dataOutput) throws IOException {
        first.write(dataOutput);
        second.write(dataOutput);
    }

    public void readFields(DataInput dataInput) throws IOException {
        first.readFields(dataInput);
        second.readFields(dataInput);
    }

    public int hashCode() {
        return first.hashCode() * 163 + second.hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof EX_TextPar) {
            EX_TextPar tp = (EX_TextPar) o;
            return first.equals(tp.first) && second.equals(tp.second);
        }
        return false;
    }

    public String toString() {
        return first + "\t" + second;
    }

}
