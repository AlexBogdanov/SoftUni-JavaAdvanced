package barracksWars.core.commands;

import barracksWars.annotations.Injection;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class Command {

    @Injection
    private Repository repository;
    @Injection
    private UnitFactory unitFactory;

    public Command(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String add(String[] data) throws NotImplementedException {
      String unitType = data[1];
      Unit unitToAdd = this.unitFactory.createUnit(unitType);
      this.repository.addUnit(unitToAdd);
      String output = unitType + " added!";
      return output;
    }

    public String report(String[] data) {
		String output = this.repository.getStatistics();
		  return output;
    }

    public String fight(String[] data) {
		  return "fight";
    }

    public String retire(String[] data) throws NotImplementedException {
      String unitType = data[1];
      try {
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
      } catch (NullPointerException npe) {
        return npe.getMessage();
      }
    }

}
