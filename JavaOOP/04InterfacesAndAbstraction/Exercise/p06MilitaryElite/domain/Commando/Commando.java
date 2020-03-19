package p06MilitaryElite.domain.Commando;

import java.util.ArrayList;
import java.util.List;

import p06MilitaryElite.domain.Corps;
import p06MilitaryElite.domain.State;
import p06MilitaryElite.domain.Mission.Mission;
import p06MilitaryElite.domain.SpecialisedSoldier.SpecialisedSoldier;

public class Commando extends SpecialisedSoldier implements ICommando {

    List<Mission> missions;

    public Commando(
        int id,
        String firstName,
        String lastName,
        double salary,
        Corps corps
    ) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(Mission m) {
        this.missions.add(m);
    }

    @Override
    public void completeMission(String cN) {
        Mission mission = this.missions.stream()
            .filter(m -> m.getCodeName().equals(cN))
            .findFirst()
            .orElse(null);

        if (mission == null) {
            return;
        }

        mission.changeState(State.FINISHED);
    }

}
