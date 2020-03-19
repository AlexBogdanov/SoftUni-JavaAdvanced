package p06MilitaryElite.domain.SpecialisedSoldier;

import p06MilitaryElite.domain.Corps;
import p06MilitaryElite.domain.LieutenantGeneral.LieutenantGeneral;

public class SpecialisedSoldier extends LieutenantGeneral implements ISpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

}
