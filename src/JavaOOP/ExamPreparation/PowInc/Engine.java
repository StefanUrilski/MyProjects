package JavaOOP.ExamPreparation.PowInc;

import JavaOOP.ExamPreparation.PowInc.command.CommandParserImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
    private static final String END_COMMAND = "Paw Paw Pawah";

    private BufferedReader reader;
    private String input;
    private CommandParserImpl commandParserImpl;

    public Engine() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.input = "";
        this.commandParserImpl = new CommandParserImpl();
    }

    @Override
    public void run() {
        this.input = readLine();

        while (true) {
            this.commandParserImpl.execute(input);

            if (input.equals(Engine.END_COMMAND)) {
                break;
            }

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
