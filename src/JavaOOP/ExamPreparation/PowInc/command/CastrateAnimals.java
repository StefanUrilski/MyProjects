package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;
import JavaOOP.ExamPreparation.PowInc.models.center.AdoptionCenter;
import JavaOOP.ExamPreparation.PowInc.models.center.CastrationCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CastrateAnimals {


    public void execute(String centerName, Map<String, CastrationCenter> castration, Map<String, AdoptionCenter> adoption) {
        HashMap<String, ArrayList<Animal>> castrate = castration.get(centerName).castrate();

//        for (Map.Entry<String, ArrayList<Animal>> entry : castrate.entrySet()) {
//            adoption.get(entry.getKey()).cleansed(entry.getValue());
//        }
    }
}
