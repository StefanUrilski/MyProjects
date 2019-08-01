package IteratorsAndComparators.ListyIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class ListIterator implements Iterable<String> {
    private ArrayList<String> list;
    private int size = 0;


    public ListIterator() {
        this.list = new ArrayList<>();
    }

    public void add(String element) {
        this.list.add(element);
    }

    public int size() {
        return this.list.size();
    }
    public boolean move() {
        if (iterator().hasNext()) {
            size++;
            return true;
        }
        return false;
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        list.forEach(action);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return size + 1 < list.size();
            }

            @Override
            public String next() {
                return list.get(size);
            }
        };
    }
}
