package JavaOOP.ExamPreparation.PowInc.command;

import JavaOOP.ExamPreparation.PowInc.models.center.CleansingCenter;

import java.util.Map;

public class RegisterCleansingCenter {


    public void execute(String[] tokens, Map<String, CleansingCenter> cleansingCenter) {
        CleansingCenter center = new CleansingCenter(tokens[1]);
        cleansingCenter.put(tokens[1], center);
    }
}
