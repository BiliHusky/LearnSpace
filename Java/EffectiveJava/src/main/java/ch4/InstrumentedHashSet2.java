package ch4;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yjw on 19-1-23.
 */
public class InstrumentedHashSet2<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet2() {
        super();
    }

    public InstrumentedHashSet2(Set<E> s) {
        super(s);
    }

    public int getAddCount() {
        return addCount;
    }

    @Override
    public boolean add(E e) {
        addCount ++ ;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public static void main(String[] args) {
        InstrumentedHashSet2<String> s = new InstrumentedHashSet2<String>();
        s.addAll(Arrays.asList("david", "peter", "harry"));
        System.out.println(s.getAddCount());
    }
}
