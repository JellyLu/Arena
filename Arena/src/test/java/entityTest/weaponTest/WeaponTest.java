package entityTest.weaponTest;

import entity.weapon.Weapon;
import entity.weapon.feature.DizzyFeature;
import entity.weapon.feature.FireFeature;
import entity.weapon.feature.IceFeature;
import entity.weapon.feature.PoisonFeature;
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
    private Weapon          weapon;
    private Random          random;
    private RandomGenerator randomGenerator;
    @Before
    public void setUp() {
        random = mock( Random.class );
        randomGenerator = new RandomGenerator( random );
        weapon = new Weapon("锤", 2, randomGenerator );
    }

    @Test
    public void when_use_weapon_without_feature_return_string() {
        when( random.nextInt(10) ).thenReturn( 4 );
        assertThat( weapon.useWeapon(), is("用锤"));
    }

    @Test
    public void when_use_weapon_damage_lose_bleed() {
        assertThat( weapon.getBleed(), is( 2 ));
    }

    @Test
    public void when_use_weapon_with_poison_feature_return_string() {
        weapon.setFeature( new PoisonFeature() );
        String result = weapon.useWeapon();
        when( random.nextInt(Constant.RANDOM_MAX) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_POISON - 1 );

        assertThat( result, is("用毒锤"));
    }

    @Test
    public void when_use_weapon_with_dizzy_feature_return_string() {
        weapon.setFeature( new DizzyFeature() );
        String result = weapon.useWeapon();
        when( random.nextInt(Constant.RANDOM_MAX) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_DIZZY - 1 );
        assertThat( result, is("用晕锤"));

    }

    @Test
    public void when_use_weapon_with_fire_feature_return_string() {
        weapon.setFeature( new FireFeature() );
        String result = weapon.useWeapon();
        when( random.nextInt(Constant.RANDOM_MAX) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_FIRE - 1 );
        assertThat( result, is("用火锤"));

    }

    @Test
    public void when_use_weapon_with_ice_feature_return_string() {
        weapon.setFeature( new IceFeature() );
        String result = weapon.useWeapon();
        when( random.nextInt(Constant.RANDOM_MAX) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_FIRE- 1 );
        assertThat( result, is("用冰雪锤"));

    }
}
