package CounterStriker.models.players;

import static CounterStriker.common.ExceptionMessages.*;

import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl implements Player {

    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setAlive();
        this.setGun(gun);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().length() < 1) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setAlive() {
        this.isAlive = this.health > 0 ? true : false;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        while (points > 0 && this.armor > 0) {
            this.armor -= 1;
            points -= 1;
        }

        if (this.armor > 0) return;

        while (points > 0 && this.health > 0) {
            this.health -= 1;
            points -= 1;
        }

        if (this.health == 0) this.isAlive = false;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()))
            .append(System.lineSeparator())
            .append(String.format("--Health: %d", this.getHealth()))
            .append(System.lineSeparator())
            .append(String.format("--Armor: %d", this.getArmor()))
            .append(System.lineSeparator())
            .append(String.format("--Gun: %s", this.getGun().getName()))
            .toString().trim();
    }

}
