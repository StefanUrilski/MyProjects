package JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.commands;

import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Executable;

public abstract class CommandImpl implements Executable {
    private String[] data;

    public CommandImpl(String[] data) {
        super();
        this.data = data;
    }

    public String[] getData() {
        return this.data;
    }

}
