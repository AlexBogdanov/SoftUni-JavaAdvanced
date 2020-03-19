package p06MilitaryElite.domain;

public enum State {

    INPROGRESS("inProgress"),
    FINISHED("Finished");

    private String val;

    private State(String val) {
        this.val = val;
    }

    public String getStateValue() {
        return this.val;
    }

}
