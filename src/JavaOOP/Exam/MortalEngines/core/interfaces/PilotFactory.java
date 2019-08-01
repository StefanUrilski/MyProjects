package JavaOOP.Exam.MortalEngines.core.interfaces;

import JavaOOP.Exam.MortalEngines.entities.interfaces.Pilot;

public interface PilotFactory {
    Pilot createPilot(String name);
}
