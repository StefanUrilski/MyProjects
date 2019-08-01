package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.models.center.CastrationCenter;

import java.util.Map;

public class RegisterCastrationCenter {

    public void execute(String[] tokens, Map<String, CastrationCenter> adoptionCenter) {
        CastrationCenter center = new CastrationCenter(tokens[1]);
        adoptionCenter.put(tokens[1], center);
    }
}
