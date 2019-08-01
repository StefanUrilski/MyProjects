package IteratorsAndComparators.StrategyPattern;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        int compare = this.name.length() - o.name.length();
        if (compare == 0) {
            return this.name.toLowerCase().charAt(0) - o.name.toLowerCase().charAt(0);
        }
        return compare;
    }

    public int compareToByAge(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
