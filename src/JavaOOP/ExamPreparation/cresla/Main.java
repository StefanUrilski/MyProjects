package JavaOOP.ExamPreparation.cresla;


import JavaOOP.ExamPreparation.cresla.interfaces.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = new BaseManager();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            String cmd = tokens[0];
            List<String> arg = Arrays.stream(tokens).skip(1).collect(Collectors.toList());

            switch (cmd) {
                case "Reactor":
                    System.out.println(manager.reactorCommand(arg));
                    break;
                case "Module":
                    System.out.println(manager.moduleCommand(arg));
                    break;
                case "Report":
                    System.out.println(manager.reportCommand(arg));
                    break;
                case "Exit":
                    System.out.println(manager.exitCommand(arg));
                    return;
            }
        }
    }
}
