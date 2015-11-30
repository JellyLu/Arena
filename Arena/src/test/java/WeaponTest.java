import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WeaponTest {
    private Weapon weapon;

    @Before
    public void setUp() {
        weapon = new Weapon("茅", 2);
    }

    @Test
    public void when_use_weapon_return_string() {

        assertThat( weapon.useWeapon(), is("用茅"));

    }

    @Test
    public void when_use_weapon_damage() {

        assertThat( weapon.getDamage(), is( 2 ));

    }
}
