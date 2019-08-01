package JavaOOP.Workshop.SystemSplit.repository;

import JavaOOP.Workshop.SystemSplit.hardware.Hardware;
import JavaOOP.Workshop.SystemSplit.software.Software;
import JavaOOP.Workshop.SystemSplit.hardware.HardwareUsage;

import java.util.HashMap;
import java.util.Map;

public class SystemRepository {
    private Map<String, HardwareUsage> powerHardware;
    private Map<String, HardwareUsage> heavyHardware;
    private Map<String, HardwareUsage> powerDump;
    private Map<String, HardwareUsage> heavyDump;
    private int softwareComponents;
    private int softwareDump;

    public SystemRepository() {
        this.powerHardware = new HashMap<>();
        this.heavyHardware = new HashMap<>();
        this.powerDump = new HashMap<>();
        this.heavyDump = new HashMap<>();
        this.softwareComponents = 0;
        this.softwareDump = 0;
    }

    public void addHardware(Hardware hardware) {
        if (hardware.getType().equals("Power")) {
            this.addHardwareToRepository(this.powerHardware, hardware);
        } else {
            this.addHardwareToRepository(this.heavyHardware, hardware);
        }
    }

    public void addSoftware(String hardwareName, Software software) {
        boolean successful = false;
        if (this.powerHardware.containsKey(hardwareName)) {
            successful = this.powerHardware.get(hardwareName).addSoftware(software);
        } else if (this.heavyHardware.containsKey(hardwareName)) {
            successful = this.heavyHardware.get(hardwareName).addSoftware(software);
        }

        if (successful) { this.softwareComponents++; }
    }

    public void releaseSoftware(String hardwareName, String softwareName) {
        boolean successful = false;
        if (this.powerHardware.containsKey(hardwareName)) {
            successful = this.powerHardware.get(hardwareName).releaseSoftware(softwareName);
        } else if (this.heavyHardware.containsKey(hardwareName)) {
            successful = this.heavyHardware.get(hardwareName).releaseSoftware(softwareName);
        }

        if (successful) { this.softwareComponents--; }
    }

    public String analyze() {
        StringBuilder sb = new StringBuilder();
        int[] powerUsage = calculateSystemUsage(this.powerHardware);
        int[] heavyUsage = calculateSystemUsage(this.heavyHardware);

        String memory = String.format("%s / %s", powerUsage[2] + heavyUsage[2], powerUsage[3] + heavyUsage[3]);
        String capacity = String.format("%s / %s", powerUsage[0] + heavyUsage[0], powerUsage[1] + heavyUsage[1]);

        int hardwareComponents = this.heavyHardware.size() + this.powerHardware.size();

        sb.append("System Analysis").append(System.lineSeparator());
        sb.append("Hardware Components: ").append(hardwareComponents).append(System.lineSeparator());
        sb.append("Software Components: ").append(this.softwareComponents).append(System.lineSeparator());
        sb.append("Total Operational Memory: ").append(memory).append(System.lineSeparator());
        sb.append("Total Capacity Taken: ").append(capacity).append(System.lineSeparator());
        return sb.toString();
    }

    public String systemSplit() {
        StringBuilder sb = new StringBuilder();

        appendingSystemSplitInformation(sb, this.powerHardware, "Type: Power");
        appendingSystemSplitInformation(sb, this.heavyHardware, "Type: Heavy");

        return sb.toString();
    }

    public void dump(String hardwareName) {
        if (this.powerHardware.containsKey(hardwareName)) {
            dumpHardware(this.powerHardware, this.powerDump, hardwareName);
        } else if (this.heavyHardware.containsKey(hardwareName)) {
            dumpHardware(this.heavyHardware, this.heavyDump, hardwareName);
        }
    }

    public void restore(String hardwareName) {
        if (this.powerDump.containsKey(hardwareName)) {
            restoreHardware(this.powerDump, this.powerHardware, hardwareName);
        } else if (this.heavyDump.containsKey(hardwareName)) {
            restoreHardware(this.heavyDump, this.heavyHardware, hardwareName);
        }
    }

    public void destroy(String hardwareName) {
        if (this.powerDump.containsKey(hardwareName)) {
            this.powerDump.remove(hardwareName);
        } else this.heavyDump.remove(hardwareName);
    }

    public String dumpAnalyze() {
        StringBuilder sb = new StringBuilder();
        int[] powerUsage = calculateSystemUsage(this.powerDump);
        int[] heavyUsage = calculateSystemUsage(this.heavyDump);

        String overallMemory = String.format("%s", powerUsage[2] + heavyUsage[2]);
        String overallCapacity = String.format("%s", powerUsage[0] + heavyUsage[0]);

        sb.append("Dump Analysis").append(System.lineSeparator());
        sb.append("Power Hardware Components: ").append(this.powerDump.size()).append(System.lineSeparator());
        sb.append("Heavy Hardware Components: ").append(this.heavyDump.size()).append(System.lineSeparator());
        sb.append("Express Software Components: ").append(this.getExpressSoftwareCount()).append(System.lineSeparator());
        sb.append("Light Software Components: ").append(this.getLightSoftwareCount()).append(System.lineSeparator());
        sb.append("Total Dumped Memory: ").append(overallMemory).append(System.lineSeparator());
        sb.append("Total Dumped Capacity: ").append(overallCapacity).append(System.lineSeparator());
        return sb.toString();
    }

    private int getExpressSoftwareCount() {
        int result = 0;
        for (HardwareUsage value : this.powerDump.values()) {
           result += value.getExpressSoftwareCount();
        }
        for (HardwareUsage value : this.heavyDump.values()) {
            result += value.getExpressSoftwareCount();
        }
        return result;
    }

    private int getLightSoftwareCount() {
        return this.softwareDump - getExpressSoftwareCount();
    }

    private void restoreHardware(Map<String, HardwareUsage> dump, Map<String, HardwareUsage> hardware, String hardwareName) {
        HardwareUsage tempUsage = dump.get(hardwareName);
        this.softwareComponents += tempUsage.softwareComponentsCount();
        this.softwareDump -= tempUsage.softwareComponentsCount();
        dump.remove(hardwareName);
        hardware.put(hardwareName, tempUsage);
    }

    private void dumpHardware(Map<String, HardwareUsage> hardware, Map<String, HardwareUsage> dump, String hardwareName) {
        HardwareUsage tempUsage = hardware.get(hardwareName);
        this.softwareComponents -= tempUsage.softwareComponentsCount();
        this.softwareDump += tempUsage.softwareComponentsCount();
        hardware.remove(hardwareName);
        dump.put(hardwareName, tempUsage);
    }

    private void addHardwareToRepository(Map<String,HardwareUsage> typeOfHardware, Hardware hardware) {
        HardwareUsage usage = new HardwareUsage(hardware.getCapacitySize(), hardware.getMemorySize());
        typeOfHardware.put(hardware.getName(), usage);
    }

    private int[] calculateSystemUsage(Map<String,HardwareUsage> typeOfHardware) {
        int[] result = new int[4];
        for (HardwareUsage hardwareUsage : typeOfHardware.values()) {
            result[0] += hardwareUsage.getCurrentCapacity();
            result[1] += hardwareUsage.getTotalCapacity();
            result[2] += hardwareUsage.getCurrentMemory();
            result[3] += hardwareUsage.getTotalMemory();
        }

        return result;
    }

    private void appendingSystemSplitInformation(StringBuilder sb, Map<String, HardwareUsage> hardware, String type) {
        for (Map.Entry<String, HardwareUsage> entry : hardware.entrySet()) {
            sb.append("Hardware Component - ").append(entry.getKey()).append(System.lineSeparator());
            sb.append(entry.getValue().toString());
            sb.append(type).append(System.lineSeparator());
            if (entry.getValue().softwareComponentsCount() == 0) {
                sb.append("Software Components: None").append(System.lineSeparator());
            } else {
                sb.append("Software Components: ").append(entry.getValue().getSoftwareComponents())
                        .append(System.lineSeparator());
            }
        }
    }

}
