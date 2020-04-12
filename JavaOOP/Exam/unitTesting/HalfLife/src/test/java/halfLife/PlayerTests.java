package halfLife;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {

    private Gun gun;
    private Player player;
    
    @Before
    public void init() {
        this.gun = new Gun("Gun", 10);
        this.player = new Player("Player", 10);
    }

    // ctor()
    @Test(expected = NullPointerException.class)
    public void ctor_should_throw_npe_when_null_name_is_passed() {
        // GIVEN / WHEN / THEN NullPointerException
        new Player(null, 100);
    }
    
    @Test(expected = NullPointerException.class)
    public void ctor_should_throw_npe_when_whitespace_name_is_passed() {
        // GIVEN / WHEN / THEN NullPointerException
        new Player(" ", 100);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ctor_should_throw_npe_when_negative_health_is_passed() {
        // GIVEN / WHEN / THEN IllegalArgumentException
        new Player("Player", -100);
    }

    // getUsername()
    @Test
    public void getUsername_should_return_username() {
        // GIVEN / WHEN
        String res = this.player.getUsername();

        // THEN
        assertEquals(this.player.getUsername(), res);
    }

    // getHealth()
    @Test
    public void getHealth_should_return_health() {
        // GIVEN / WHEN
        int res = this.player.getHealth();

        // THEN
        assertEquals(this.player.getHealth(), res);
    }

    // getGuns()
    @Test(expected = UnsupportedOperationException.class)
    public void getGuns_should_throw_uoe_if_guns_are_modified() {
        // GIVEN
        this.player.addGun(this.gun);
        Collection<Gun> guns = this.player.getGuns();

        // WHEN / THEN UnsupportedOperationException
        guns.clear();
    }

    @Test
    public void getGuns_should_return_guns() {
        // GIVEN
        this.player.addGun(this.gun);

        // WHEN
        Collection<Gun> res = this.player.getGuns();

        // THEN
        Gun[] arr = { this.gun };
        Collection<Gun> exp = Arrays.asList(arr);
        assertEquals(exp, res);
    }

    // takeDamage()
    @Test(expected = IllegalStateException.class)
    public void takeDamage_should_throw_ise_if_player_is_alredy_dead() {
        // GIVEN
        this.player.takeDamage(15);

        // WHEN / THEN IllegalStateException
        this.player.takeDamage(15);
    }

    @Test
    public void takeDamage_should_reduce_health() {
        // GIVEN
        this.player.takeDamage(5);

        // WHEN
        int res = this.player.getHealth();

        // THEN
        assertEquals(5, res);
    }

    @Test
    public void takeDamage_should_reduce_health_to_0() {
        // GIVEN
        this.player.takeDamage(15);

        // WHEN
        int res = this.player.getHealth();

        // THEN
        assertEquals(0, res);
    }

    // addGun()
    @Test(expected = NullPointerException.class)
    public void addGun_should_throw_npe_if_gun_is_null() {
        // GIVEN / WHEN / THEN NullPointerException
        this.player.addGun(null);
    }

    // removeGun()
    @Test
    public void removeGun_should_return_true_if_gun_is_removed() {
        // GIVEN
        this.player.addGun(this.gun);

        // WHEN
        boolean res = this.player.removeGun(this.gun);

        // THEN
        assertTrue(res);
    }
    
    @Test
    public void removeGun_should_return_false_if_gun_is_not_removed() {
        // GIVEN / WHEN
        boolean res = this.player.removeGun(this.gun);

        // THEN
        assertFalse(res);
    }

    // getGun()
    @Test
    public void getGun_should_return_gun_if_present() {
        // GIVEN
        this.player.addGun(this.gun);

        // WHEN
        Gun res = this.player.getGun(this.gun.getName());

        // THEN
        assertEquals(this.gun, res);
    }

    
    @Test
    public void getGun_should_return_null_if_gun_not_present() {
        // GIVEN / WHEN
        Gun res = this.player.getGun(this.gun.getName());

        // THEN
        assertEquals(null, res);
    }

}
