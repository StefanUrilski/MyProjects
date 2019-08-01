package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;
import JavaOOP.ExamPreparation.PowInc.models.center.AdoptionCenter;
import JavaOOP.ExamPreparation.PowInc.models.center.CastrationCenter;

import java.util.ArrayList;
import java.util.Map;

public class SendForCastration {

    public void execute(String[] tokens, Map<String, AdoptionCenter> adoptionCenter, Map<String, CastrationCenter> castrationCenter) {
        ArrayList<Animal> animalsForCleansing = adoptionCenter.get(tokens[1]).sendForCleansing();
        castrationCenter.get(tokens[2]).receiveForCastration(tokens[1], animalsForCleansing);
    }
}
