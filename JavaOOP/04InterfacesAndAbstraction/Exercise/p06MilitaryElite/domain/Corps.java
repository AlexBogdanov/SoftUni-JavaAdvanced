package p06MilitaryElite.domain;

public enum Corps {

    AIRFORCES("Airforces"),
    MARINES("Marines");

    private String val;

    private Corps(String val) {
        this.val = val;
    }

    public String getCorpsValue() {
        return this.val;
    }

}
