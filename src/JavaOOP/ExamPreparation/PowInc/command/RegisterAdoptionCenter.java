package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.models.center.AdoptionCenter;

import java.util.Map;

public class RegisterAdoptionCenter {


    public void execute(String[] tokens, Map<String, AdoptionCenter> adoptionCenter) {
        AdoptionCenter center = new AdoptionCenter(tokens[1]);
        adoptionCenter.put(tokens[1], center);
    }
}
