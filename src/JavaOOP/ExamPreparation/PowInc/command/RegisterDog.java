package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;
import JavaOOP.ExamPreparation.PowInc.models.animal.Dog;
import JavaOOP.ExamPreparation.PowInc.models.center.AdoptionCenter;

import java.util.Map;

public class RegisterDog {
    public void execute(String[] tokens, Map<String, AdoptionCenter> adoptionCenter) {
        Animal dog = new Dog(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        adoptionCenter.get(tokens[4]).addAnimal(dog);
    }
}
