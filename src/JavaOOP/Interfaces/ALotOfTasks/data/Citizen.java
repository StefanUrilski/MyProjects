package JavaOOP.Interfaces.ALotOfTasks.data;

import JavaOOP.Interfaces.ALotOfTasks.contracts.Birthable;
import JavaOOP.Interfaces.ALotOfTasks.contracts.Buyer;
import JavaOOP.Interfaces.ALotOfTasks.contracts.Identifiable;
import JavaOOP.Interfaces.ALotOfTasks.contracts.Person;

public class Citizen implements Person, Identifiable, Birthable, Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;


    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

}
