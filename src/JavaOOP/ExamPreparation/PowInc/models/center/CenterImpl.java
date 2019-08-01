package JavaOOP.ExamPreparation.PowInc.models.center;

import JavaOOP.ExamPreparation.PowInc.intefaces.Center;

public class CenterImpl implements Center {
    private String name;
    private String type;

    public CenterImpl(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
