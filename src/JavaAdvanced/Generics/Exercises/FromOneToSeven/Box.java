package Generics.Exercises.FromOneToSeven;

public class Box <T extends Comparable<T>>{
    private T elem;

    public Box (T elem) {
        this.elem = elem;
    }


    public boolean compereTo(T elem) {
        return this.elem.compareTo(elem) > 0;
    }
    @Override
    public String toString() {
        return this.elem.getClass().getName() + ": " + this.elem;
    }
}
