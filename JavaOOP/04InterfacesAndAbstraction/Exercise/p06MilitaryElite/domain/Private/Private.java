package p06MilitaryElite.domain.Private;

import p06MilitaryElite.domain.Soldier.Soldier;

public class Private extends Soldier implements IPrivate {

    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

}
