package JavaOOP.Workshop.SystemSplit.software;

public class Express extends Software {

    public Express(String name, int capacityNeeded, int memoryNeeded) {
        super(name, capacityNeeded, memoryNeeded);
        this.setType("Express");
    }

    @Override
    protected void setMemoryNeeded(int memoryNeeded) {
        super.setMemoryNeeded(memoryNeeded * 2);
    }
}
