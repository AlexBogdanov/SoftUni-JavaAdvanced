package p06MilitaryElite.domain.Spy;

import p06MilitaryElite.domain.Soldier.Soldier;

public class Spy extends Soldier implements ISpy {

    private String codeName;

    public Spy(int id, String firstName, String lastName, String codeName) {
        super(id, firstName, lastName);
        this.codeName = codeName;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String toString() {
        return String.format(
            "Name: %s %s Id: %d%nCode Number: %s",
            this.getFirstName(),
            this.getLastName(),
            this.getId(),
            this.getCodeName()
        );
    }

}
