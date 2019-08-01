package JavaOOP.Workshop.SystemSplit.hardware;

public class Power extends Hardware {

    public Power(String name, int capacitySize, int memorySize) {
        super(name, capacitySize, memorySize);
        this.setType("Power");
    }

    @Override
    protected void setCapacitySize(int capacitySize) {
        super.setCapacitySize(capacitySize - (int) (capacitySize * 0.75));
    }

    @Override
    protected void setMemorySize(int memorySize) {
        super.setMemorySize(memorySize + (int) (memorySize * 0.75));
    }
}
