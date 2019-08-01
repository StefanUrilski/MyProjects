package JavaOOP.ExamPreparation.cresla;

import JavaOOP.ExamPreparation.cresla.entities.modules.CooldownSystem;
import JavaOOP.ExamPreparation.cresla.entities.modules.CryogenRod;
import JavaOOP.ExamPreparation.cresla.entities.modules.HeatProcessor;
import JavaOOP.ExamPreparation.cresla.entities.reactors.CryoReactor;
import JavaOOP.ExamPreparation.cresla.entities.reactors.HeatReactor;
import JavaOOP.ExamPreparation.cresla.interfaces.EnergyModule;
import JavaOOP.ExamPreparation.cresla.interfaces.Manager;
import JavaOOP.ExamPreparation.cresla.interfaces.Module;
import JavaOOP.ExamPreparation.cresla.interfaces.Reactor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseManager implements Manager {
    private Map<Integer, Reactor> storage;
    private Map<Integer, Module> moduleStorage;
    private static int id;

    public BaseManager() {
        this.storage = new HashMap<>();
        this.moduleStorage = new HashMap<>();
        id = 1;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Reactor reactor = null;
        String result = "";
        String type = arguments.get(0);
        int requiredIndex = Integer.parseInt(arguments.get(1));
        int capacity = Integer.parseInt(arguments.get(2));

        if (type.equals("Cryo")) {
            reactor = new CryoReactor(id++, requiredIndex, capacity);
            result = String.format("Created Cryo Reactor - %d", reactor.getId());
        } else /* if (type.equals("Heat")) */ {
            reactor = new HeatReactor(id++, requiredIndex, capacity);
            result = String.format("Created Heat Reactor - %d", reactor.getId());
        }

        this.storage.put(reactor.getId(), reactor);
        return result;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        String result = "";
        Module module;
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int param = Integer.parseInt(arguments.get(2));

        if (type.equals("CryogenRod")) {
            module = new CryogenRod(id++, param);
            this.storage.get(reactorId).addEnergyModule((CryogenRod) module);
            result = String.format("Added CryogenRod - %d to Reactor - %d", module.getId(), reactorId);
        } else if (type.equals("HeatProcessor")) {
            module = new HeatProcessor(id++, param);
            this.storage.get(reactorId).addAbsorbingModule((HeatProcessor) module);
            result = String.format("Added HeatProcessor - %d to Reactor - %d", module.getId(), reactorId);
        } else /* if (type.equals("CoolingSystem")) */ { // may be CooldownSystem ?
            module = new CooldownSystem(id++, param);
            this.storage.get(reactorId).addAbsorbingModule((CooldownSystem) module);
            result = String.format("Added CooldownSystem - %d to Reactor - %d", module.getId(), reactorId);
        }

        this.moduleStorage.put(module.getId(), module);
        return result;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        String result;
        int id = Integer.parseInt(arguments.get(0));

        if (storage.containsKey(id)) {
            result = storage.get(id).toString();
        } else {
            result = moduleStorage.get(id).toString();
        }

        return result;
    }

    @Override
    public String exitCommand(List<String> arguments) {

        return "Cryo Reactors: " + getCryoReactorsCount() + "\n" +
                "Heat Reactors: " + (this.storage.size() - this.getCryoReactorsCount()) + "\n" +
                "Energy Modules: " + this.getEnergyModulesCount() + "\n" +
                "Absorbing Modules: " + (this.moduleStorage.size() - this.getEnergyModulesCount()) + "\n" +
                "Total Energy Output: " + this.getTotalEnergy() + "\n" +
                "Total Heat Absorbing: " + this.getTotalHeat();
    }

    private int getCryoReactorsCount() {
        int count = 0;
        for (Reactor value : storage.values()) {
            if (value instanceof CryoReactor) {
                count++;
            }
        }
        return count;
    }

    private int getEnergyModulesCount() {
        int count = 0;
        for (Module value : moduleStorage.values()) {
            if (value instanceof EnergyModule) {
                count++;
            }
        }
        return count;
    }

    private long getTotalEnergy() {
        return this.storage.values().stream()
                .mapToLong(Reactor::getTotalEnergyOutput)
                .sum();
    }

    private long getTotalHeat() {
        return this.storage.values().stream()
                .mapToLong(Reactor::getTotalHeatAbsorbing)
                .sum();
    }
}
