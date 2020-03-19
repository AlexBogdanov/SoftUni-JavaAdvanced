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

}
