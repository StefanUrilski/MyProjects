package JavaOOP.Exam.Retake;

import JavaOOP.Exam.Retake.core.ManagerControllerImpl;
import JavaOOP.Exam.Retake.core.interfaces.ManagerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ManagerController controller = new ManagerControllerImpl();

        String input = reader.readLine();

        while (! input.equals("Exit")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "AddPlayer":
                    System.out.println(controller.addPlayer(tokens[1], tokens[2]));
                    break;
                case "AddCard":
                    System.out.println(controller.addCard(tokens[1], tokens[2]));
                    break;
                case "AddPlayerCard":
                    System.out.println(controller.addPlayerCard(tokens[1], tokens[2]));
                    break;
                case "Fight":
                    System.out.println(controller.fight(tokens[1], tokens[2]));
                    break;
                case "Report":
                    System.out.println(controller.report());
                    break;
            }

            input = reader .readLine();
        }

    }
}
