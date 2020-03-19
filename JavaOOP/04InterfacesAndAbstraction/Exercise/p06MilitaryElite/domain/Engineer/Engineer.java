package p06MilitaryElite.domain.Engineer;

import java.util.LinkedHashSet;
import java.util.Set;

import p06MilitaryElite.domain.Corps;
import p06MilitaryElite.domain.Repair.Repair;
import p06MilitaryElite.domain.SpecialisedSoldier.SpecialisedSoldier;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private Set<Repair> repairs;

    public Engineer(
        int id,
        String firstName,
        String lastName,
        double salary,
        Corps corps
    ) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder repairsStr = new StringBuilder();

        for (Repair repair : this.repairs) {
            repairsStr.append(System.lineSeparator()).append(repair.toString());
        }

        return String.format(
            "Name: %s %s Id: %d Salary: %.2f%nCorps: %s%nRepairs:%s",
            this.getFirstName(),
            this.getLastName(),
            this.getId(),
            this.getSalary(),
            this.getCorps().getCorpsValue(),
            repairsStr.toString()
        );
    }

}
