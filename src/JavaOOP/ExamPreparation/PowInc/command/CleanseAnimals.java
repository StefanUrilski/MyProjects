package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;
import JavaOOP.ExamPreparation.PowInc.models.center.AdoptionCenter;
import JavaOOP.ExamPreparation.PowInc.models.center.CleansingCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CleanseAnimals {

    public void execute(String centerName, Map<String, CleansingCenter> cleansing, Map<String, AdoptionCenter> adoption) {
        HashMap<String, ArrayList<Animal>> cleanse = cleansing.get(centerName).cleanse();

        for (Map.Entry<String, ArrayList<Animal>> entry : cleanse.entrySet()) {
            adoption.get(entry.getKey()).cleansed(entry.getValue());
        }
    }
}
