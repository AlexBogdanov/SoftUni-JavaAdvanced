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

}
