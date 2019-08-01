package JavaOOP.Workshop.SystemSplit.hardware;

public class Heavy extends Hardware {

    public Heavy(String name, int capacitySize, int memorySize) {
        super(name, capacitySize, memorySize);
        this.setType("Heavy");
    }

    @Override
    protected void setCapacitySize(int capacitySize) {
        super.setCapacitySize(capacitySize * 2);
    }

    @Override
    protected void setMemorySize(int memorySize) {
        super.setMemorySize(memorySize - (int) (memorySize * 0.25));
    }
}
