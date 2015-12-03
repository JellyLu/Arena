package entityTest.weaponTest.weaponTest;

import entity.player.Assassin;
import entity.player.Knight;
import entity.player.Soldier;
import entity.weapon.feature.IceFeature;
import entity.weapon.weapon.MiddleWeapon;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import util.Constant;
import util.IllUseWeaponException;
import util.RandomGenerator;

import java.util.Random;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class MiddleWeaponTest {

    private MiddleWeapon middleWeapon;

    @Mock
    private Random random;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        middleWeapon = new MiddleWeapon( "长枪", 3, new RandomGenerator( random ));
        middleWeapon.setFeature( new IceFeature() );
    }

    @Test(expected = IllUseWeaponException.class)
    public void throw_exception_when_assassin_use_long_weapon_feature() throws Exception{
        Assassin assassin = new Assassin( "张三", 20, 8 );

        middleWeapon.useWeapon( assassin );
        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.DAMAGE_TYPE_TWICE_CAN_NOT_ATTACK_ONCE - 1 );
    }

    @Test(expected = IllUseWeaponException.class)
    public void throw_exception_when_knight_use_long_weapon_feature() throws Exception{
        Knight knight = new Knight( "张三", 20, 8 );

        middleWeapon.useWeapon( knight );
        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.DAMAGE_TYPE_TWICE_CAN_NOT_ATTACK_ONCE - 1 );
    }

    @Test
    public void not_throw_exception_when_soldier_use_long_weapon_feature() throws Exception{
        Soldier soldier = new Soldier( "张三", 20, 8 );

        try {
            middleWeapon.useWeapon( soldier );
            when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.DAMAGE_TYPE_TWICE_CAN_NOT_ATTACK_ONCE - 1 );

        }catch( IllUseWeaponException e ){
            fail();
        }

    }
}
