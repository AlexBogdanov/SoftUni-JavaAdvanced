package p06MilitaryElite.domain.Repair;

public class Repair implements IRepair {

    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
	public int getHoursWorked() {
		return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format(
            "  Part Name: %s Hours Worked: %d",
            this.getPartName(),
            this.getHoursWorked()
        );
    }

}
