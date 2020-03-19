package p06MilitaryElite.domain.LieutenantGeneral;

import java.util.LinkedHashSet;
import java.util.Set;

import p06MilitaryElite.domain.Private.Private;

public class LieutenantGeneral extends Private implements ILieutenantGeneral {

    private Set<Private> privates;

    public LieutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    @Override
    public void addPrivate(Private privateSoldier) {
        this.privates.add(privateSoldier);
    }

    @Override
    public Set<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder privateStr = new StringBuilder();

        this.privates.stream()
            .sorted((p1, p2) -> {
                if (p1.getId() > p2.getId()) { return -1; }
                if (p1.getId() < p2.getId()) { return 1; }
                return 0;
            }).forEachOrdered(p -> {
                privateStr.append(System.lineSeparator()).append("  " + p.toString());
            });

        return String.format(
            "Name: %s %s Id: %d Salary: %.2f%nPrivates:%s",
            this.getFirstName(),
            this.getLastName(),
            this.getId(),
            this.getSalary(),
            privateStr.toString()
        );
    }

}
