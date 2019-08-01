package JavaOOP.ExamPreparation.PowInc.models.animal;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;

public class AnimalImpl implements Animal {
    private String name;
    private int age;

    public AnimalImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
