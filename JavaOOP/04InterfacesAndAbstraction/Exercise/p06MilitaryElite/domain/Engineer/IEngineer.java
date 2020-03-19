package p06MilitaryElite.domain.Engineer;

import java.util.Set;

import p06MilitaryElite.domain.Repair.Repair;

public interface IEngineer {

    Set<Repair> getRepairs();
    void addRepair(Repair r);

}
