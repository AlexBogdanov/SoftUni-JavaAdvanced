package com.github.AlexBogdanov.rpg_tests;

import com.github.AlexBogdanov.rpg_lab.Hero;
import com.github.AlexBogdanov.rpg_lab.Target;
import com.github.AlexBogdanov.rpg_lab.Weapon;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {
    
    @Test
    public void gaining_exp_when_killing_a_target() {
        // GIVEN
        var weaponMock = Mockito.mock(Weapon.class);
        var targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(10);
        var hero = new Hero("hero", weaponMock);

        // WHEN
        hero.attack(targetMock);

        // THEN
        Assert.assertEquals(10, hero.getExperience());
    }

}
