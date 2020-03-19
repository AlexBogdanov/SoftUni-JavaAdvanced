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

    @Override
    public String toString() {
        StringBuilder missionsStr = new StringBuilder();

        this.missions.stream()
            .filter(m -> m.getState().getStateValue().equals(State.INPROGRESS.getStateValue()))
            .forEach(m -> {
                missionsStr.append(System.lineSeparator()).append(m.toString());
            });

        return String.format(
            "Name: %s %s Id: %d Salary: %.2f%nCorps: %s%nMissions:%s",
            this.getFirstName(),
            this.getLastName(),
            this.getId(),
            this.getSalary(),
            this.getCorps().getCorpsValue(),
            missionsStr.toString()
        );
    }

}
