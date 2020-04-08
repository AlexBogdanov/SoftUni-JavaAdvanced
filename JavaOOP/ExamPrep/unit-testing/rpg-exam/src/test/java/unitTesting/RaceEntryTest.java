package unitTesting;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RaceEntryTest {

    private RaceEntry raceEntry;

    @Before
    public void init() {
        this.raceEntry = new RaceEntry();
    }

    // addRider()
    @Test(expected = NullPointerException.class)
    public void addRider_should_throw_npe_if_the_passed_rider_is_null() {
        // GIVEN
        UnitRider rider = null;

        // WHEN / THEN NullPointerException should be thrown
        this.raceEntry.addRider(rider);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRider_should_throw_iae_if_rider_is_already_present() {
        // GIVEN
        UnitRider rider1 = new UnitRider("name", null);
        UnitRider rider2 = new UnitRider("name", null);

        // WHEN / THEN IllegalArgumentException should be thrown
        this.raceEntry.addRider(rider1);
        this.raceEntry.addRider(rider2);
    }

    @Test
    public void addRider_should_return_String_msg_when_rider_is_added_successully()     {
        // GIVEN
        UnitRider rider = new UnitRider("name", null);

        // WHEN
        var msg = this.raceEntry.addRider(rider);

        // THEN
        var exp = "Rider name added in race.";
        assertEquals(exp, msg);
    }

    // calculateAverageHorsePower()
    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePower_should_throw_iae_if_race_participants_are_less_than_2() {
        // GIVEN
        this.raceEntry.addRider(new UnitRider("name", null));

        // WHEN / THEN IllegalArgumentException should be thrown
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAverageHorsePower_should_return_avg_hp_if_there_are_enough_participants() {
        // GIVEN
        var motorcycle1 = new UnitMotorcycle("model1", 10, 5);
        var motorcycle2 = new UnitMotorcycle("model2", 20, 15);
        var rider1 = new UnitRider("name1", motorcycle1);
        var rider2 = new UnitRider("name2", motorcycle2);
        this.raceEntry.addRider(rider1);
        this.raceEntry.addRider(rider2);

        // WHEN
        double res = this.raceEntry.calculateAverageHorsePower();

        // THEN
        assertEquals(15, res, 0);
    }

    // getRiders()
    @Test(expected = UnsupportedOperationException.class)
    public void getRiders_should_thorw_uoe_if_riders_are_modified() {
        // GIVEN
        this.raceEntry.addRider(new UnitRider("name1", null));
        this.raceEntry.addRider(new UnitRider("name2", null));
        Collection<UnitRider> riders = this.raceEntry.getRiders();

        // WHEN / THEN
        riders.clear();
    }
}
