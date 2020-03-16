package p04SayHelloExtended.domain;

public abstract class BasePerson implements Person {

    private String name;

    public BasePerson(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }


}
