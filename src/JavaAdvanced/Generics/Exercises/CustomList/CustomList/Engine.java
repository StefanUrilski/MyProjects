package Generics.Exercises.CustomList.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
    private static final String END_COMMAND = "END";
    private BufferedReader reader;
    private String input;
    private CommandParser commandParser;

    public Engine() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.input = "";
        this.commandParser = new CommandParser();
    }
    @Override
    public void run() {

        this.input = readLine();

        while (!input.equals(Engine.END_COMMAND)) {
            this.commandParser.execute(input);
            input = readLine();
        }


    }
    private String readLine() {
        String result = "";
        try {
            result = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return result;
    }
}
