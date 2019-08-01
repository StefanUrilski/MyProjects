package JavaOOP.ExamPreparation.PowInc.models.center;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;

import java.util.ArrayList;
import java.util.List;

public class AdoptionCenter extends CenterImpl {
    private static final String TYPE = "AdoptionCenter";
    private String name;
    private ArrayList<Animal> forCleansing;
    private ArrayList<Animal> readyForAdoption;
    private ArrayList<Animal> adopted;

    public AdoptionCenter(String name) {
        super(name, AdoptionCenter.TYPE);
        this.forCleansing = new ArrayList<>();
        this.readyForAdoption = new ArrayList<>();
        this.adopted = new ArrayList<>();
    }

    public void cleansed(List<Animal> cleansed) {
        this.forCleansing.removeAll(cleansed);
        this.readyForAdoption.addAll(cleansed);
    }

    public void adopted() {
        this.adopted.addAll(this.readyForAdoption);
        this.readyForAdoption.clear();
    }

    public void addAnimal(Animal animal) {
        this.forCleansing.add(animal);
    }

    public ArrayList<Animal> sendForCleansing() {
        return this.forCleansing;
    }

    public ArrayList<Animal> getAdoptedAnimals() {
        return adopted;
    }

    public int readyForAdoptionCount() {
        return this.readyForAdoption.size();
    }
}
