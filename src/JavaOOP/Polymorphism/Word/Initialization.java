package JavaOOP.Polymorphism.Word;

import JavaOOP.Polymorphism.Word.command.AdvancedCommand;
import JavaOOP.Polymorphism.Word.contracts.CommandInterface;

public class Initialization {
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new AdvancedCommand(text);
        commandInterface.init();
        return commandInterface;
    }
}
