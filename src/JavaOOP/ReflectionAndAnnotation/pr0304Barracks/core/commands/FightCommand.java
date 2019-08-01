package JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.commands;

public class FightCommand extends CommandImpl {

    public FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
