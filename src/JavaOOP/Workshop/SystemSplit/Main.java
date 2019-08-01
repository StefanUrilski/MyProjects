package JavaOOP.Workshop.SystemSplit;

import JavaOOP.Workshop.SystemSplit.hardware.Hardware;
import JavaOOP.Workshop.SystemSplit.hardware.Heavy;
import JavaOOP.Workshop.SystemSplit.hardware.Power;
import JavaOOP.Workshop.SystemSplit.repository.SystemRepository;
import JavaOOP.Workshop.SystemSplit.software.Express;
import JavaOOP.Workshop.SystemSplit.software.Light;
import JavaOOP.Workshop.SystemSplit.software.Software;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SystemRepository repository = new SystemRepository();

        String line = reader.readLine();
        while (! line.equals("System Split")) {
            String[] tokens = line.split("[(,)\\s]+");
            String command = tokens[0];

            if (command.endsWith("Hardware")) {
                int capacity = Integer.parseInt(tokens[2]);
                int memory = Integer.parseInt(tokens[3]);
                Hardware hardware;

                if (command.contains("Power")) {
                    hardware = new Power(tokens[1], capacity, memory);
                } else {
                    hardware = new Heavy(tokens[1], capacity, memory);
                }

                repository.addHardware(hardware);
            } else if (command.endsWith("Software")) {
                int capacity = Integer.parseInt(tokens[3]);
                int memory = Integer.parseInt(tokens[4]);
                Software software;

                if (command.contains("Light")) {
                    software = new Light(tokens[2], capacity, memory);
                } else {
                    software = new Express(tokens[2], capacity, memory);
                }

                repository.addSoftware(tokens[1], software);
            } else if (command.endsWith("Component")) {
                repository.releaseSoftware(tokens[1], tokens[2]);
            } else if (command.equals("Analyze")) {
                System.out.print(repository.analyze());
            } else if (command.equals("Dump")) {
                repository.dump(tokens[1]);
            } else if (command.equals("Restore")) {
                repository.restore(tokens[1]);
            } else if (command.equals("Destroy")) {
                repository.destroy(tokens[1]);
            } else if (command.equals("DumpAnalyze")) {
                System.out.println(repository.dumpAnalyze());
            }

            line = reader.readLine();
        }

        System.out.print(repository.systemSplit());
    }
}
