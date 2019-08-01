package JavaOOP.Workshop.SystemSplit.software;

public abstract class Software {
    private String name;
    private int capacityNeeded;
    private int memoryNeeded;
    private String type;

    public Software(String name, int capacityNeeded, int memoryNeeded) {
        this.name = name;
        this.setCapacityNeeded(capacityNeeded);
        this.setMemoryNeeded(memoryNeeded);
        this.type = "";
    }

    public String getName() {
        return this.name;
    }

    public int getCapacityNeeded() {
        return this.capacityNeeded;
    }

    protected void setCapacityNeeded(int capacityNeeded) {
        this.capacityNeeded = capacityNeeded;
    }

    public int getMemoryNeeded() {
        return this.memoryNeeded;
    }

    protected void setMemoryNeeded(int memoryNeeded) {
        this.memoryNeeded = memoryNeeded;
    }

    public String getType() {
        return this.type;
    }

    protected void setType(String type) {
        this.type = type;
    }
}
