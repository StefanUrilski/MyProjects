package JavaOOP.Exam.MortalEngines.entities;

import JavaOOP.Exam.MortalEngines.entities.interfaces.Machine;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pilot name cannot be null or empty string.");
        }

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null) {
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }

        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" - ").append(this.machines.size()).append(" machines");
        if (!this.machines.isEmpty()) {
            sb.append("\n");
        }
        this.machines.forEach(machine -> sb.append("- ")
                .append(machine.getName()).append("\n")
                .append(machine.toString()));

        return sb.toString();
    }
}
