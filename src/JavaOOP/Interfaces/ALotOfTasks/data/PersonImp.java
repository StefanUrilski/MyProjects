package JavaOOP.Interfaces.ALotOfTasks.data;

import JavaOOP.Interfaces.ALotOfTasks.contracts.Buyer;
import JavaOOP.Interfaces.ALotOfTasks.contracts.Person;

public abstract class PersonImp implements Buyer, Person {
    private String name;
    private int age;
    private int food;

    protected PersonImp(String name, int age, int food) {
        this.name = name;
        this.age = age;
        this.food = food;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
