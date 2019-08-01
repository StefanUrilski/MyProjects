package JavaOOP.ExamPreparation.PowInc.models.center;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;

import java.util.ArrayList;
import java.util.HashMap;

public class CastrationCenter extends CenterImpl {
    private static final String TYPE = "CastrationCenter";

    private HashMap<String, ArrayList<Animal>> storage;
    private ArrayList<Animal> castratedAnimals;

    public CastrationCenter(String name) {
        super(name, CastrationCenter.TYPE);
        this.storage = new HashMap<>();
        this.castratedAnimals = new ArrayList<>();
    }

    public void receiveForCastration(String adoptionCenter, ArrayList<Animal> animals) {
        this.storage.putIfAbsent(adoptionCenter, new ArrayList<>());
        this.storage.get(adoptionCenter).addAll(animals);
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, ArrayList<Animal>> castrate () {
        HashMap<String, ArrayList<Animal>> temp = (HashMap<String, ArrayList<Animal>>)this.storage.clone();
        temp.values().forEach(castratedAnimals::addAll);
        this.storage.clear();
        return temp;
    }

    public ArrayList<Animal> getCleansedAnimals() {
        return this.castratedAnimals;
    }
}
