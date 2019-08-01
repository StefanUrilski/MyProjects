package JavaOOP.ReflectionAndAnnotation.pr0304Barracks.core.factories;

import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.Unit;
import JavaOOP.ReflectionAndAnnotation.pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"JavaOOP.ReflectionAndAnnotation.pr0304Barracks.JavaOOP.Exam.Retake.JavaOOP.Exam.Retake.models.units.";

	@SuppressWarnings("unchecked")
	@Override
	public Unit createUnit(String unitType) {

		Unit unit = null;
		try {
			Class<? extends Unit> unitClass = (Class<Unit>) Class.forName(UnitFactoryImpl.UNITS_PACKAGE_NAME + unitType);
			Constructor<? extends Unit> constructor = unitClass.getDeclaredConstructor();
			constructor.setAccessible(true);
			unit = constructor.newInstance();

		} catch (NoSuchMethodException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return unit;
	}
}
