package JavaOOP.UnitTesting.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Database<T> {
    private ArrayDeque<T> data;

    public Database() {
        this.data = new ArrayDeque<>(16);
    }

    public void add(T number) throws OperationNotSupportedException {
        if (number == null) {
            throw new OperationNotSupportedException();
        }
        if (this.data.size() == 16) {
            throw new OperationNotSupportedException();
        }
        this.data.push(number);
    }

    public void remove() {
        this.data.pop();
    }

    @SuppressWarnings("unchecked")
    public T[] fetch() {
        T[] result = (T[]) Array.newInstance(Person.class, this.data.size());
        //int[] result = new int[this.data.size()];
        for (int i = 0; i < this.data.size(); i++) {
            result[i] = data.iterator().next();
        }
        return result;
    }

    public int size() {
        return this.data.size();
    }


}
