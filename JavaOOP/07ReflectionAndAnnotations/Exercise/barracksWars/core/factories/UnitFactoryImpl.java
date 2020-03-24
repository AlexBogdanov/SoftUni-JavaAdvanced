package barracksWars.core.factories;

import java.lang.reflect.Constructor;
import jdk.jshell.spi.ExecutionControl;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		try {
			Class<Unit> unitClass = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> ctor = unitClass.getDeclaredConstructor();
			return ctor.newInstance();
		} catch (Exception e) {
			throw new ExecutionControl.NotImplementedException("message");
		}
	}
}
