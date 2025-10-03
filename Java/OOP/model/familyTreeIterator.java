package model;

import java.util.Iterator;
import java.util.List;

public class familyTreeIterator<T> implements Iterator<T> {
    private int count;
    private List<T> unknowns;

    public familyTreeIterator(List<T> objects) {
        this.count = 0;
        this.unknowns = objects;
    }

    @Override
    public boolean hasNext() {
        return count < unknowns.size();
    }

    @Override
    public T next() {
        if (!hasNext()) return null;
        return unknowns.get(count++);
    }
}