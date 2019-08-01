package JavaOOP.ExamPreparation.PowInc.models.center;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CleansingCenter extends CenterImpl {
    private static final String TYPE = "CleansingCenter";

    private HashMap<String, ArrayList<Animal>> storage;
    private ArrayList<Animal> cleansedAnimals;

    public CleansingCenter(String name) {
        super(name, CleansingCenter.TYPE);
        this.storage = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, ArrayList<Animal>> cleanse() {
        HashMap<String, ArrayList<Animal>> temp = (HashMap<String, ArrayList<Animal>>)this.storage.clone();
        temp.values().forEach(cleansedAnimals::addAll);
        this.storage.clear();
        return temp;
    }

    public void receiveForCleansing(String adoptionCenter, List<Animal> animals) {
        this.storage.putIfAbsent(adoptionCenter, new ArrayList<>());
        this.storage.get(adoptionCenter).addAll(animals);
    }

    public ArrayList<Animal> getCleansedAnimals() {
        return this.cleansedAnimals;
    }

    public int readyForCleansing() {
        ArrayList<Animal> temp = new ArrayList<>();
        this.storage.values().forEach(temp::addAll);

        return temp.size();
    }
}
