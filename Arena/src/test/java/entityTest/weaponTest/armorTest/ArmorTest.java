package entityTest.weaponTest.armorTest;

import entity.weapon.armor.Armor;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArmorTest {
    private Armor armor;

    @Before
    public void setUp() {
        armor = new Armor("盾", 3);
    }

    @Test
    public void when_use_armor_return_string() {

        assertThat(armor.useArmor(), is("用盾防御"));

    }

    @Test
    public void when_use_armor_defence_damage() {

        assertThat( armor.getDefenceDamage(), is( 3 ));

    }
}
