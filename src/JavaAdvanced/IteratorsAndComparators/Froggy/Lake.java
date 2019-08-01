package IteratorsAndComparators.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Lake<T extends Integer> implements Iterable<Integer> {
    private ArrayList<Integer> list;

    public Lake(Integer... values) {
        this.list = new ArrayList<>(Arrays.asList(values));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private  int index;
        private Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if (this.index >= list.size() && this.index % 2 == 0) {
                this.index = 1;
                return true;
            }
            return index < list.size();
        }

        @Override
        public Integer next() {
            int result = list.get(this.index);
            this.index += 2;
            return result;
        }
    }



}
