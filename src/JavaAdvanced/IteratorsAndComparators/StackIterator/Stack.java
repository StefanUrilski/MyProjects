package IteratorsAndComparators.StackIterator;

import java.util.ArrayDeque;
import java.util.function.Consumer;

public class Stack {
    private ArrayDeque<Integer> stack;

    public Stack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int element) {
        this.stack.push(element);
    }

    public int pop() {
        return this.stack.pop();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void forEach(Consumer<? super Integer> action) {
        this.stack.forEach(action);
    }

}
