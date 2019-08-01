package JavaOOP.Workshop.SystemSplit.software;

public class Light extends Software {

    public Light(String name, int capacityNeeded, int memoryNeeded) {
        super(name, capacityNeeded, memoryNeeded);
        this.setType("Light");
    }

    @Override
    protected void setCapacityNeeded(int capacityNeeded) {
        super.setCapacityNeeded(capacityNeeded + (int) (capacityNeeded * 0.5));
    }

    @Override
    protected void setMemoryNeeded(int memoryNeeded) {
        super.setMemoryNeeded(memoryNeeded - (int) (memoryNeeded * 0.5));
    }
}
