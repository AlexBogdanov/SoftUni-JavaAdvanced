package p07Google.classes;

public class Pokemon {

    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public Pokemon(String name, String element) {
        this.name = name;
        this.element = element;
        this.health = -1;
    }

    public String getName() {
        return this.name;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
