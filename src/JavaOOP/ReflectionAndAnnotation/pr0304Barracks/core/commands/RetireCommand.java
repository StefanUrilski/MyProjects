package JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.commands;

import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Inject;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Repository;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends CommandImpl {
    @Inject
    private Repository repository;

    public RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String result;
        try {
            this.repository.removeUnit(getData()[1]);
            result = getData()[1] + " retired!";
        } catch (ExecutionControl.NotImplementedException e) {
            result = e.getMessage();
        }

        return result;
    }
}
