package JavaOOP.Interfaces.MilitaryElite.models;

public class Spy extends SoldierImpl {
    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Code Number: " + this.codeNumber;
    }
}
