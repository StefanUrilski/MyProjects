package JavaOOP.Exam.MortalEngines.core;

import JavaOOP.Exam.MortalEngines.common.OutputMessages;
import JavaOOP.Exam.MortalEngines.core.interfaces.MachineFactory;
import JavaOOP.Exam.MortalEngines.core.interfaces.PilotFactory;
import JavaOOP.Exam.MortalEngines.core.interfaces.MachinesManager;

import JavaOOP.Exam.MortalEngines.entities.interfaces.Fighter;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Machine;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Pilot;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {

        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }

    @Override
    public String hirePilot(String name) {
        if (this.pilots.containsKey(name)) {
            return String.format(OutputMessages.pilotExists, name);
        }
        Pilot pilot = pilotFactory.createPilot(name);
        this.pilots.put(name, pilot);

        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        String result;
        Machine tank = this.machineFactory.createTank(name, attackPoints, defensePoints);

        if (this.machines.containsKey(name)){
            result = String.format(OutputMessages.machineExists, name);
        } else {
            this.machines.put(name, tank);
            result = String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
        }

        return result;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        String result;
        Machine fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);

        if (this.machines.containsKey(name)){
            result = String.format(OutputMessages.machineExists, name);
        } else {
            this.machines.put(name, fighter);
            result = String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
        }

        return result;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (! this.pilots.containsKey(selectedPilotName)) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }

        if (this.machines.get(selectedMachineName).getPilot() != null) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

        Pilot pilot = this.pilots.get(selectedPilotName);

        this.machines.get(selectedMachineName).setPilot(pilot);
        this.pilots.get(selectedPilotName).addMachine(this.machines.get(selectedMachineName));

        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        String result;

        if (! this.machines.containsKey(attackingMachineName)) {
            result = String.format(OutputMessages.machineNotFound, attackingMachineName);
        } else if (! this.machines.containsKey(defendingMachineName)) {
            result = String.format(OutputMessages.machineNotFound, defendingMachineName);
        } else {
            double defenderHealthPoints = this.machines.get(defendingMachineName).getHealthPoints();
            double defenderDefensePoints = this.machines.get(defendingMachineName).getDefensePoints();
            double attackerAttackPoints = this.machines.get(attackingMachineName).getAttackPoints();

            if (defenderDefensePoints < attackerAttackPoints) {
                if (attackerAttackPoints > defenderHealthPoints + defenderDefensePoints) {
                    defenderHealthPoints = 0;
                } else {
                    defenderHealthPoints = (defenderHealthPoints + defenderDefensePoints) - attackerAttackPoints;
                }

                this.machines.get(defendingMachineName).setHealthPoints(defenderHealthPoints);
            }
            result = String.format(OutputMessages.attackSuccessful,
                    defendingMachineName, attackingMachineName, defenderHealthPoints);

            this.machines.get(attackingMachineName).attack(defendingMachineName);
        }

        return result;
    }

    @Override
    public String pilotReport(String pilotName) {
        if (this.pilots.containsKey(pilotName)) {
            return this.pilots.get(pilotName).report();
        }
        return String.format(OutputMessages.pilotNotFound, pilotName);
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (this.machines.get(fighterName) instanceof Fighter) {
            ((Fighter) (this.machines.get(fighterName))).toggleAggressiveMode();
            return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
        }

        return String.format(OutputMessages.notSupportedOperation, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (this.machines.get(tankName) instanceof Tank) {
            ((Tank) (this.machines.get(tankName))).toggleDefenseMode();
            return String.format(OutputMessages.tankOperationSuccessful, tankName);
        }

        return String.format(OutputMessages.notSupportedOperation, tankName);
    }
}
