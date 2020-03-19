package p06MilitaryElite.domain.Mission;

import p06MilitaryElite.domain.State;

public class Mission implements IMission {

    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void changeState(State newState) {
        this.state = newState;
    }

}
