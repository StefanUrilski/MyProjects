package JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.commands;

import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Inject;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Repository;

public class ReportCommand extends CommandImpl {
    @Inject
    private Repository repository;

    public ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
