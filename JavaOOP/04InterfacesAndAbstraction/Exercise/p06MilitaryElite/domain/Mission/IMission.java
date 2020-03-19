package p06MilitaryElite.domain.Mission;

import p06MilitaryElite.domain.State;

public interface IMission {

    String getCodeName();
    State getState();
    void changeState(State s);

}
