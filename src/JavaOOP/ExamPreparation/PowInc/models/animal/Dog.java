package JavaOOP.ExamPreparation.PowInc.models.animal;

public class Dog extends AnimalImpl {
    private int commands;

    public Dog(String name, int age, int commands) {
        super(name, age);
        this.commands = commands;
    }
}
