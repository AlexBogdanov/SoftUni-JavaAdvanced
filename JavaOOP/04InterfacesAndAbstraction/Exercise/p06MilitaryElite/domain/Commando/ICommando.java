package p06MilitaryElite.domain.Commando;

import java.util.List;

import p06MilitaryElite.domain.Mission.Mission;

public interface ICommando {

    List<Mission> getMissions();
    void addMission(Mission m);
    void completeMission(String cN);

}
