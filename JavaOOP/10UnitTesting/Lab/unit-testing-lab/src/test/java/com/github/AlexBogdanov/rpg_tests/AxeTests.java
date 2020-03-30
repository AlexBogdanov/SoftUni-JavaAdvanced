package com.github.AlexBogdanov.rpg_tests;

import com.github.AlexBogdanov.rpg_lab.Axe;
import com.github.AlexBogdanov.rpg_lab.Dummy;

import org.junit.Assert;
import org.junit.Test;

public class AxeTests {

    @Test
    public void weapon_looses_durability_when_attacking() {
        // GIVEN
        var dummy = new Dummy(1, 1);
        var axe = new Axe(2, 2);

        // WHEN
        axe.attack(dummy);

        // THEN
        Assert.assertEquals(1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attacking_with_broken_weapn_should_throw_ise() {
        // GIVEN
        var dummy = new Dummy(1, 1);
        var axe = new Axe(1, 0);

        // WHEN / THEN IllegalStateException should be thrown
        axe.attack(dummy);
    }

}
