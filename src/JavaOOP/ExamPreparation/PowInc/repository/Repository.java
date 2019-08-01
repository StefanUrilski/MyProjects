package JavaOOP.ExamPreparation.PowInc.repository;

import JavaOOP.ExamPreparation.PowInc.intefaces.Animal;
import JavaOOP.ExamPreparation.PowInc.models.center.AdoptionCenter;
import JavaOOP.ExamPreparation.PowInc.models.center.CastrationCenter;
import JavaOOP.ExamPreparation.PowInc.models.center.CleansingCenter;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Repository {
    private Map<String, AdoptionCenter> adoptionCenter;
    private Map<String, CleansingCenter> cleansingCenter;
    private Map<String, CastrationCenter> castrationCenter;

    public Repository() {
        this.adoptionCenter = new HashMap<>();
        this.cleansingCenter = new HashMap<>();
        this.castrationCenter = new HashMap<>();
    }

    public Map<String, AdoptionCenter> getAdoptionCenter() {
        return this.adoptionCenter;
    }

    public Map<String, CleansingCenter> getCleansingCenter() {
        return this.cleansingCenter;
    }

    public Map<String, CastrationCenter> getCastrationCenter() {
        return this.castrationCenter;
    }

    public String adoptedAnimalsNames() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Animal> allAdoptedAnimals = new ArrayList<>();

        for (AdoptionCenter value : this.adoptionCenter.values()) {
            allAdoptedAnimals.addAll(value.getAdoptedAnimals());
        }

        if (allAdoptedAnimals.isEmpty()) {
            return "None";
        }

        sortingAndAppendingAnimals(sb, allAdoptedAnimals);
        return sb.toString();
    }

    public String cleansedAnimalsNames() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Animal> allCleansedAnimals = new ArrayList<>();

        for (CleansingCenter value : this.cleansingCenter.values()) {
            allCleansedAnimals.addAll(value.getCleansedAnimals());
        }

        if (allCleansedAnimals.isEmpty()) {
            return "None";
        }

        sortingAndAppendingAnimals(sb, allCleansedAnimals);
        return sb.toString();
    }

    public String castratedAnimalsNames() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Animal> allCastratedAnimals = new ArrayList<>();

        for (CastrationCenter value : this.castrationCenter.values()) {
            allCastratedAnimals.addAll(value.getCleansedAnimals());
        }

        if (allCastratedAnimals.isEmpty()) {
            return "None";
        }

        sortingAndAppendingAnimals(sb, allCastratedAnimals);
        return sb.toString();
    }

    public int awaitingAdoptionCount() {
        int count = 0;
        for (AdoptionCenter center : this.adoptionCenter.values()) {
            count += center.readyForAdoptionCount();
        }

        return count;
    }

    public int awaitingCleansingCount() {
        int count = 0;
        for (CleansingCenter center : this.cleansingCenter.values()) {
            count += center.readyForCleansing();
        }

        return count;
    }

    public int adoptionCenterCount() {
        return this.adoptionCenter.size();
    }

    public int cleansingCenterCount() {
        return this.cleansingCenter.size();
    }

    public int castrationCenterCount() {
        return this.castrationCenter.size();
    }

    private void sortingAndAppendingAnimals(StringBuilder sb, ArrayList<Animal> allAnimals) {
        List<String> sorted = allAnimals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        sb.append(String.join(", ", sorted));
    }
}