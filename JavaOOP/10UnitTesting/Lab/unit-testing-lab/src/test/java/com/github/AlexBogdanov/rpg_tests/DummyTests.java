package com.github.AlexBogdanov.rpg_tests;

import com.github.AlexBogdanov.rpg_lab.Axe;
import com.github.AlexBogdanov.rpg_lab.Dummy;
import com.github.AlexBogdanov.rpg_lab.Hero;
import com.github.AlexBogdanov.rpg_lab.Weapon;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DummyTests {

    @Test
    public void dummy_losing_health_when_attacked() {
        // GIVEN
        var dummy = new Dummy(5, 5);

        // WHEN
        dummy.takeAttack(2);

        // THEN
        Assert.assertEquals(3, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void dead_dummy_throws_ise_when_attacked() {
        // GIVEN
        var dummy = new Dummy(0, 5);

        // WHEN / THEN IllegalStateException should be thrown
        dummy.takeAttack(2);
    }

    @Test
    public void dead_dummy_should_give_exp() {
        // GIVEN
        var dummy = new Dummy(9, 10);
        Weapon weapon = new Axe(10, 2);
        var hero = new Hero("hero", weapon);

        // WHEN
        hero.attack(dummy);

        // THEN
        Assert.assertEquals(10, hero.getExperience());
    }

    @Test
    public void alive_dummy_should_not_give_exp() {
        // GIVEN
        var dummy = new Dummy(11, 10);
        var weaponMock = Mockito.mock(Weapon.class);
        var hero = new Hero("hero", weaponMock);

        // WHEN
        hero.attack(dummy);

        // THEN
        Assert.assertEquals(0, hero.getExperience());
    }

}
