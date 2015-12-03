package entityTest.playerTest;

import entity.player.Player;
import entity.player.Soldier;
import entity.weapon.Armor;
import entity.weapon.Weapon;
import entity.weapon.feature.*;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import util.Constant;
import util.RandomGenerator;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class SoldierTest {
    private Soldier soldier;
    private Player player;
    private Armor armor;
    private Weapon weapon;
    private RandomGenerator randomGenerator;
    @Mock
    private Random random;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        randomGenerator  = new RandomGenerator( random );
        soldier          = new Soldier( "lu", 20, 11 );
        player           = new Player( "yang", 20, 10 );
        armor            = new Armor( "盾", 4 );
        weapon           = new Weapon( "矛", 3, randomGenerator );
    }

    @Test
    public void should_soldier_beat_player_without_weapon_and_armor(){
        assertThat( soldier.beat( player ), is("战士lu攻击了普通人yang,yang受到了11点伤害,yang剩余生命值:9\n") );
    }

    @Test
    public void should_soldier_beat_player_with_weapon_without_feature_without_armor(){
        soldier.wearWeapon( weapon );
        assertThat( soldier.beat( player ), is("战士lu用矛攻击了普通人yang,yang受到了14点伤害,yang剩余生命值:6\n") );
    }

    @Test
    public void should_soldier_defence_player_with_armor(){
        soldier.wearArmor( armor );
        assertThat( player.beat( soldier ), is("普通人yang攻击了战士lu,lu用盾防御,lu受到了6点伤害,lu剩余生命值:14\n") );
    }

    @Test
    public void  should_damage_not_change_after_soldier_wear_armor(){
        int oldDamage = soldier.getBleed();
        soldier.wearArmor( armor );

        assertThat( soldier.getBleed(), is( oldDamage ));
    }

    @Test
    public void should_damage_increase_after_soldier_wear_weapon(){
        int oldDamage = soldier.getBleed();
        soldier.wearWeapon( weapon );

        assertThat( soldier.getBleed(), Is.is( oldDamage + weapon.getBleed() ));
    }

    @Test
    public void should_soldier_beat_player_with_weapon_with_poison_feature_without_armor(){
        weapon.setFeature( new PoisonFeature());
        soldier.wearWeapon( weapon );
        String result = soldier.beat( player );
        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_POISON - 1 );
        assertThat(  result, is("战士lu用毒矛攻击了普通人yang,yang受到了14点伤害,yang中毒了,yang剩余生命值:6\n" +
                                "yang受到了2点毒性伤害,yang剩余生命值:4\n") );
    }

    @Test
    public void should_soldier_beat_player_with_weapon_with_fire_feature_without_armor(){
        weapon.setFeature( new FireFeature());
        soldier.wearWeapon( weapon );
        String result = soldier.beat( player );
        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_FIRE - 1 );
        assertThat(  result, is("战士lu用火矛攻击了普通人yang,yang受到了14点伤害,yang被火烧了,yang剩余生命值:6\n" +
                "yang受到了3点火焰伤害,yang剩余生命值:3\n") );
    }

    @Test
    public void should_soldier_beat_player_with_weapon_with_ice_feature_without_armor(){
        weapon.setFeature( new IceFeature());
        soldier.wearWeapon( weapon );
        String result = soldier.beat( player );
        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_ICE - 1 );
        assertThat(  result, is("战士lu用冰雪矛攻击了普通人yang,yang受到了14点伤害,yang被冻僵了,yang剩余生命值:6\n") );
    }

    @Test
    public void should_soldier_beat_player_with_weapon_with_dizzy_feature_without_armor(){
        weapon.setFeature( new DizzyFeature());
        soldier.wearWeapon( weapon );
        String result = soldier.beat( player );
        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_DIZZY - 1 );
        assertThat(  result, is("战士lu用晕矛攻击了普通人yang,yang受到了14点伤害,yang晕倒了,yang剩余生命值:6\n" +
                "yang晕倒了,眩晕还剩:4轮\n") );
    }

    @Test
    public void should_soldier_beat_player_with_weapon_with_all_effor_feature_without_armor(){
        weapon.setFeature( new AllEffortFeature());
        soldier.wearWeapon( weapon );
        String result = soldier.beat( player );
        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( Constant.FEATURE_DAMAGE_TIMES_ALL_EFFORT - 1 );
        assertThat(  result, is("战士lu用矛攻击了普通人yang,lu发动了全力一击,yang受到了42点伤害,yang剩余生命值:-22\n") );
    }
}
