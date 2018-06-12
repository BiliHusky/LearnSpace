package write;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
/**
 * Created by yjw on 18-3-8.
 */
public class WritableComparableAndComparators {
    public static void main(String[] args) {
        
    }

    @Test
    public void test() throws IOException {
        RawComparator<IntWritable> comparator = WritableComparator.get(IntWritable.class);
        IntWritable w1 = new IntWritable(13);
        IntWritable w2 = new IntWritable(12);
        assertThat(comparator.compare(w1, w2), greaterThan(0));
        System.out.println(comparator.compare(w1, w2));

        byte[] b1 = WritableTest.serialize(w1);
        byte[] b2 = WritableTest.serialize(w2);
        assertThat(comparator.compare(b1, 0, b1.length, b2, 0, b2.length), greaterThan(0));
        System.out.println(comparator.compare(b1, 0, b1.length, b2, 0, b2.length));
    }
}
