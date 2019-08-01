package JavaOOP.CommunicationAndEvents.EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener listener = new Handler();

        dispatcher.addNameChangeListener(listener);

        String input = reader.readLine();

        while (! input.equals("End")) {
            dispatcher.setName(input);

            input = reader.readLine();
        }

    }
}
