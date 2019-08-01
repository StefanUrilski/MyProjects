package JavaOOP.ExamPreparation.cresla.entities.modules;

import JavaOOP.ExamPreparation.cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends BaseModule implements EnergyModule {
    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput){
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        return String.format("Energy Output: %s\n", this.getEnergyOutput());
    }

}
