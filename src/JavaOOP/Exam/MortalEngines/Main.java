package JavaOOP.Exam.MortalEngines;

import JavaOOP.Exam.MortalEngines.core.MachineFactoryImpl;
import JavaOOP.Exam.MortalEngines.core.MachinesManagerImpl;

import JavaOOP.Exam.MortalEngines.core.PilotFactoryImpl;
import JavaOOP.Exam.MortalEngines.core.interfaces.MachineFactory;
import JavaOOP.Exam.MortalEngines.core.interfaces.PilotFactory;
import JavaOOP.Exam.MortalEngines.core.interfaces.MachinesManager;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Machine;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Pilot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        PilotFactory pilotFactory = new PilotFactoryImpl(); //TODO change null with your implementation
        MachineFactory machineFactory = new MachineFactoryImpl(); //TODO change null with your implementation
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (! line.equals("Over")) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Hire":
                    System.out.println(machinesManager.hirePilot(tokens[1]));
                    break;
                case "ManufactureTank":
                    System.out.println(machinesManager.manufactureTank(
                            tokens[1],
                            Double.parseDouble(tokens[2]),
                            Double.parseDouble(tokens[3])));
                    break;
                case "ManufactureFighter":
                    System.out.println(machinesManager.manufactureFighter(
                            tokens[1],
                            Double.parseDouble(tokens[2]),
                            Double.parseDouble(tokens[3])));
                    break;
                case "Engage":
                    System.out.println(machinesManager.engageMachine(tokens[1], tokens[2]));
                    break;
                case "Attack":
                    System.out.println(machinesManager.attackMachines(tokens[1], tokens[2]));
                    break;
                case "AggressiveMode":
                    System.out.println(machinesManager.toggleFighterAggressiveMode(tokens[1]));
                    break;
                case "DefenseMode":
                    System.out.println(machinesManager.toggleTankDefenseMode(tokens[1]));
                    break;
                case "Report":
                    System.out.println(machinesManager.pilotReport(tokens[1]));
                    break;
            }

            line = reader.readLine();
        }
    }
}
