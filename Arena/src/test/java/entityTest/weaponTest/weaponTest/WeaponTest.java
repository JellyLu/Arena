package entityTest.weaponTest.weaponTest;

import entity.player.Player;
import entity.weapon.feature.DizzyFeature;
import entity.weapon.feature.FireFeature;
import entity.weapon.feature.IceFeature;
import entity.weapon.feature.PoisonFeature;
import entity.weapon.weapon.Weapon;
import org.junit.Before;
import org.junit.Test;
import util.Constant;
import util.RandomGenerator;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeaponTest {
    private Weapon  weapon;
    private Random  random;
    private Player  player;
    @Before
    public void setUp() {
        random = mock( Random.class );
        weapon = new Weapon("锤", 2, new RandomGenerator( random ) );
        player = new Player( "lu", 20, 3 );
    }

    @Test
    public void when_use_weapon_without_feature_return_string() throws Exception {
        assertThat(weapon.useWeapon(player), is("用锤"));
    }

    @Test
    public void when_use_weapon_damage_lose_bleed() {
        assertThat( weapon.getBleed(), is( 2 ));
    }

    @Test
    public void when_use_weapon_with_poison_feature_return_string() throws Exception{
        weapon.setFeature( new PoisonFeature() );

        String result = weapon.useWeapon(player);
        when( random.nextInt(Constant.RANDOM_MAX) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_POISON - 1 );

        assertThat( result, is("用毒锤"));
    }

    @Test
    public void when_use_weapon_with_dizzy_feature_return_string()  throws Exception{
        weapon.setFeature( new DizzyFeature() );

        String result = weapon.useWeapon(player);
        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_DIZZY - 1);

        assertThat(result, is("用晕锤"));
    }

    @Test
    public void when_use_weapon_with_fire_feature_return_string() throws Exception{
        weapon.setFeature( new FireFeature() );

        String result = weapon.useWeapon(player);
        when( random.nextInt(Constant.RANDOM_MAX) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_FIRE - 1 );

        assertThat( result, is("用火锤"));
    }

    @Test
    public void when_use_weapon_with_ice_feature_return_string()  throws Exception{
        weapon.setFeature( new IceFeature() );

        String result = weapon.useWeapon(player);
        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_FIRE - 1);

        assertThat(result, is("用冰雪锤"));
    }
}
