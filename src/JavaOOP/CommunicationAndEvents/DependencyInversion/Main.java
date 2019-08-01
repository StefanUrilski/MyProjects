package JavaOOP.CommunicationAndEvents.DependencyInversion;

import JavaOOP.CommunicationAndEvents.DependencyInversion.common.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Calculator calculator = new Calculator();

        while (! input.equals("End")) {
            String[] tokens = input.split("\\s+");

            if (tokens[0].equals("mode")) {
                calculator.changeStrategy(tokens[1]);
            } else  {
                int first = Integer.parseInt(tokens[0]);
                int second = Integer.parseInt(tokens[1]);

                System.out.println(calculator.calculate(first, second));
            }

            input = reader.readLine();
        }

    }
}
