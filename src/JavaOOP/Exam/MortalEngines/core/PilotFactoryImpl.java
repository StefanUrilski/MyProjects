package JavaOOP.Exam.MortalEngines.core;

import JavaOOP.Exam.MortalEngines.core.interfaces.PilotFactory;
import JavaOOP.Exam.MortalEngines.entities.interfaces.Pilot;
import JavaOOP.Exam.MortalEngines.entities.PilotImpl;

public class PilotFactoryImpl implements PilotFactory {
    @Override
    public Pilot createPilot(String name) {
        return new PilotImpl(name);
    }
}
