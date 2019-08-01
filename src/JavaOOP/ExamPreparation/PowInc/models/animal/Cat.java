package JavaOOP.ExamPreparation.PowInc.models.animal;

public class Cat extends AnimalImpl {
    private int intelligence;

    public Cat(String name, int age, int intelligence) {
        super(name, age);
        this.intelligence = intelligence;
    }
}
