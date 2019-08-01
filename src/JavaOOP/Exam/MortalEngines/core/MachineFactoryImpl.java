package JavaOOP.Exam.MortalEngines.core;

import JavaOOP.Exam.MortalEngines.core.interfaces.MachineFactory;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Fighter;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Tank;
import JavaOOP.Exam.MortalEngines.entities.FighterImpl;
import JavaOOP.Exam.MortalEngines.entities.TankImpl;

public class MachineFactoryImpl implements MachineFactory {
    @Override
    public Tank createTank(String name, double attackPoints, double defensePoints) {
        return new TankImpl(name,attackPoints, defensePoints);
    }

    @Override
    public Fighter createFighter(String name, double attackPoints, double defensePoints) {
        return new FighterImpl(name, attackPoints, defensePoints);
    }
}
