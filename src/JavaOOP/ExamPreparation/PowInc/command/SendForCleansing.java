package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;
import JavaOOP.ExamPreparation.PowInc.models.center.AdoptionCenter;
import JavaOOP.ExamPreparation.PowInc.models.center.CleansingCenter;

import java.util.ArrayList;
import java.util.Map;

public class SendForCleansing {
    public void execute(String[] tokens, Map<String, AdoptionCenter> adoptionCenter, Map<String, CleansingCenter> cleansingCenter) {
        ArrayList<Animal> animalsForCleansing = adoptionCenter.get(tokens[1]).sendForCleansing();
        cleansingCenter.get(tokens[2]).receiveForCleansing(tokens[1], animalsForCleansing);
    }
}
