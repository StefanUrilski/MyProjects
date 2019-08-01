package JavaOOP.Exam.MortalEngines.core.interfaces;

import JavaOOP.Exam.MortalEngines.entities.interfaces.Fighter;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Tank;

public interface MachineFactory {
    Tank createTank(String name, double attackPoints, double defensePoints);

    Fighter createFighter(String name, double attackPoints, double defensePoints);
}
