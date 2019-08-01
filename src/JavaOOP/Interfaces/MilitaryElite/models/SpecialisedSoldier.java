package JavaOOP.Interfaces.MilitaryElite.models;

public abstract class SpecialisedSoldier extends Private {
    private String corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Corps: " + this.corps;
    }
}
