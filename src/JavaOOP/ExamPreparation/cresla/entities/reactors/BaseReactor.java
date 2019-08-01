package JavaOOP.ExamPreparation.cresla.entities.reactors;

import JavaOOP.ExamPreparation.cresla.entities.containers.ModuleContainer;
import JavaOOP.ExamPreparation.cresla.interfaces.AbsorbingModule;
import JavaOOP.ExamPreparation.cresla.interfaces.Container;
import JavaOOP.ExamPreparation.cresla.interfaces.EnergyModule;
import JavaOOP.ExamPreparation.cresla.interfaces.Reactor;

public abstract class BaseReactor implements Reactor {
    private int id;
    private Container container;

    protected BaseReactor(int id, int moduleCapacity) {
        this.id = id;
        this.container = new ModuleContainer(moduleCapacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        long energyOutput = this.container.getTotalEnergyOutput();

        if (energyOutput > this.getTotalHeatAbsorbing()) {
            energyOutput = 0;
        }

        return energyOutput;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.container.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%s - %d\n" + "Energy Output: %d\n" + "Heat Absorbing: %d\n" + "Modules: %d",
                this.getClass().getSimpleName(), this.getId(), this.getTotalEnergyOutput(),
                this.getTotalHeatAbsorbing(), this.getModuleCount());
    }
}
