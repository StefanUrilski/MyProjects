package JavaOOP.Workshop.SystemSplit.hardware;

public abstract class Hardware {
    private String name;
    private int capacitySize;
    private int memorySize;
    private String type;

    public Hardware(String name, int capacitySize, int memorySize) {
        this.name = name;
        this.setCapacitySize(capacitySize);
        this.setMemorySize(memorySize);
        this.type = "";
    }

    public String getName() {
        return this.name;
    }

    public int getCapacitySize() {
        return this.capacitySize;
    }

    protected void setCapacitySize(int capacitySize) {
        this.capacitySize = capacitySize;
    }

    public int getMemorySize() {
        return this.memorySize;
    }

    protected void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public String getType() {
        return this.type;
    }

    protected void setType(String type) {
        this.type = type;
    }
}
