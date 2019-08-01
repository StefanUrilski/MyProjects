package Generics.Exercises.CustomList.CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class SmartArray<T extends Comparable<T>> implements Iterable<T> {
    private ArrayList<T> data;

    public SmartArray(){
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T temp = this.data.get(firstIndex);
        this.data.set(firstIndex, this.data.get(secondIndex));
        this.data.set(secondIndex, temp);
    }

    public int greaterThen(T element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0).toArray().length;
    }

    public T max() {
        return this.data.stream().max(T::compareTo).get();
    }

    public T min() {
        return this.data.stream().min(T::compareTo).get();
    }

    public void print(Consumer<T> consumer)  {
        this.data.forEach(consumer);
    }

    public int size() {
        return this.data.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
