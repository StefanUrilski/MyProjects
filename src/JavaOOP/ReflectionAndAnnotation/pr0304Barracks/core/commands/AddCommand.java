package JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.commands;

import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Inject;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Repository;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Unit;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends CommandImpl {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];

        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
