package JavaOOP.Workshop.SystemSplit.hardware;

import JavaOOP.Workshop.SystemSplit.software.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class HardwareUsage {
    private int currentMemory;
    private int totalMemory;
    private int currentCapacity;
    private int totalCapacity;
    private Map<String, Software> softwareComponents;

    public HardwareUsage(int capacity, int memory) {
        this.totalCapacity = capacity;
        this.totalMemory = memory;
        this.softwareComponents = new LinkedHashMap<>();
    }

    public boolean addSoftware(Software software) {
        if (software.getCapacityNeeded() + this.currentCapacity > this.totalCapacity) { return false; }

        if (software.getMemoryNeeded() + this.currentMemory > this.totalMemory) { return false; }

        this.softwareComponents.put(software.getName(), software);

        this.currentCapacity += software.getCapacityNeeded();
        this.currentMemory += software.getMemoryNeeded();

        return true;
    }

    public boolean releaseSoftware(String softwareName) {
        if (! this.softwareComponents.containsKey(softwareName)) { return false; }

        int capacityToFree = this.softwareComponents.get(softwareName).getCapacityNeeded();
        int memoryToFree = this.softwareComponents.get(softwareName).getMemoryNeeded();

        this.softwareComponents.remove(softwareName);

        this.currentCapacity -= capacityToFree;
        this.currentMemory -= memoryToFree;

        return true;
    }

    public int getCurrentMemory() {
        return this.currentMemory;
    }

    public int getTotalMemory() {
        return this.totalMemory;
    }

    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

    public int getTotalCapacity() {
        return this.totalCapacity;
    }

    public String getSoftwareComponents() {
        return String.join(", ", this.softwareComponents.keySet());
    }

    public int softwareComponentsCount() {
        return this.softwareComponents.size();
    }

    public int getExpressSoftwareCount() {
        long express = this.softwareComponents.values().stream()
                .filter(software -> software.getType().equals("Express")).count();
        return (int) express;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String memoryUsage = String.format("%d / %d", this.currentMemory, this.totalMemory);
        String capacityUsage = String.format("%d / %d", this.currentCapacity, this.totalCapacity);
        sb.append("Express Software Components - ")
                .append(this.softwareComponents.values().stream()
                        .filter(software -> software.getType().equals("Express")).count())
                .append(System.lineSeparator());
        sb.append("Light Software Components - ")
                .append(this.softwareComponents.values().stream()
                        .filter(software -> software.getType().equals("Light")).count())
                .append(System.lineSeparator());

        sb.append("Memory Usage: ").append(memoryUsage).append(System.lineSeparator());
        sb.append("Capacity Usage: ").append(capacityUsage).append(System.lineSeparator());
        return sb.toString();
    }

}
