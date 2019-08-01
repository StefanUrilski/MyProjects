package JavaOOP.ReflectionAndAnnotation.pr0304Barracks;

import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Repository;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Runnable;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.UnitFactory;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.CommandInterpreterImpl;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.Engine;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.factories.UnitFactoryImpl;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(new CommandInterpreterImpl(repository, unitFactory));
		engine.run();
	}
}
