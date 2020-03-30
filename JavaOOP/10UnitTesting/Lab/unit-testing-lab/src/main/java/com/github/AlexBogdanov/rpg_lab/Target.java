package com.github.AlexBogdanov.rpg_lab;

public interface Target {

    void takeAttack(int attackPoints);
    int getHealth();
    int giveExperience();
    boolean isDead();

}
