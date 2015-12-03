package entityTest.playerTest;

import entity.player.Knight;
import entity.player.Player;
import entity.weapon.armor.Armor;
import entity.weapon.feature.*;
import entity.weapon.weapon.LongWeapon;
import entity.weapon.weapon.MiddleWeapon;
import entity.weapon.weapon.ShortWeapon;
import entity.weapon.weapon.Weapon;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import util.Constant;
import util.IllWeaponTypeException;
import util.RandomGenerator;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class KnightTest {
    private Knight knight;
    private Player player;
    private Armor armor;
    private Weapon weapon;
    
    @Mock
    private Random random;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        
        knight  = new Knight( "lu", 20, 11 );
        player  = new Player( "yang", 20, 10 );
        armor   = new Armor( "盾", 4 );
        weapon  = new LongWeapon( "矛", 3, new RandomGenerator( random ) );
    }

    @Test
    public void should_knight_beat_player_without_weapon_and_armor() throws Exception{

        assertThat( knight.beat( player ), is("骑士lu攻击了普通人yang,yang受到了11点伤害,yang剩余生命值:9\n") );
    }

    @Test
    public void should_knight_beat_player_with_weapon_without_feature_without_armor()throws Exception{

        knight.wearWeapon(weapon);

        assertThat(knight.beat(player), is("骑士lu用矛攻击了普通人yang,yang受到了14点伤害,yang剩余生命值:6\n"));

    }

    @Test
    public void should_knight_defence_player_with_armor() throws Exception{
        knight.wearArmor( armor );

        assertThat(player.beat(knight), is("普通人yang攻击了骑士lu,lu用盾防御,lu受到了6点伤害,lu剩余生命值:14\n"));
    }

    @Test
    public void  should_damage_not_change_after_knight_wear_armor(){
        int oldDamage = knight.getBleed();

        knight.wearArmor( armor );

        assertThat( knight.getBleed(), is( oldDamage ));
    }

    @Test
    public void should_damage_increase_after_knight_wear_weapon() throws Exception{
        int oldDamage = knight.getBleed();

        knight.wearWeapon( weapon );

        assertThat( knight.getBleed(), Is.is( oldDamage + weapon.getBleed() ));

    }

    @Test
    public void should_knight_beat_player_with_weapon_with_poison_feature_without_armor() throws Exception{
        weapon.setFeature( new PoisonFeature());
        knight.wearWeapon(weapon);

        String result = knight.beat(player);
        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_POISON - 1);
        assertThat(result, is("骑士lu用毒矛攻击了普通人yang,yang受到了14点伤害,yang中毒了,yang剩余生命值:6\n" +
                    "yang受到了2点毒性伤害,yang剩余生命值:4\n"));
    }

    @Test
    public void should_knight_beat_player_with_weapon_with_fire_feature_without_armor() throws Exception{
        weapon.setFeature( new FireFeature());
        knight.wearWeapon(weapon);

        String result = knight.beat(player);
        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_FIRE - 1);
        assertThat(result, is("骑士lu用火矛攻击了普通人yang,yang受到了14点伤害,yang被火烧了,yang剩余生命值:6\n" +
                    "yang受到了3点火焰伤害,yang剩余生命值:3\n"));
    }

    @Test
    public void should_knight_beat_player_with_weapon_with_ice_feature_without_armor() throws Exception{
        weapon.setFeature( new IceFeature());
        knight.wearWeapon(weapon);

        String result = knight.beat(player);
        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_ICE - 1);
        assertThat(result, is("骑士lu用冰雪矛攻击了普通人yang,yang受到了14点伤害,yang被冻僵了,yang剩余生命值:6\n"));
    }

    @Test
    public void should_knight_beat_player_with_weapon_with_dizzy_feature_without_armor() throws Exception{
        weapon.setFeature( new DizzyFeature());
        knight.wearWeapon(weapon);

        String result = knight.beat(player);
        when( random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_DIZZY - 1 );
        assertThat(result, is("骑士lu用晕矛攻击了普通人yang,yang受到了14点伤害,yang晕倒了,yang剩余生命值:6\n" +
                    "yang晕倒了,眩晕还剩:4轮\n"));
    }

    @Test
    public void should_knight_beat_player_with_weapon_with_all_effort_feature_without_armor() throws Exception{
        weapon.setFeature( new AllEffortFeature());
        knight.wearWeapon(weapon);

        String result = knight.beat(player);
        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_ALL_EFFORT - 1);
        assertThat(result, is("骑士lu用矛攻击了普通人yang,lu发动了全力一击,yang受到了42点伤害,yang剩余生命值:-22\n"));
    }

    @Test
    public void not_throw_exception_when_knight_wear_middle_weapon(){
        MiddleWeapon middleWeapon = new MiddleWeapon( "剑", 3, new RandomGenerator( random ));
        middleWeapon.setFeature( new FireFeature());
        try {
            knight.wearWeapon(middleWeapon);
            when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_FIRE - 1);

        }catch ( IllWeaponTypeException e ){
           fail();
        }
    }

    @Test( expected = IllWeaponTypeException.class )
    public void throw_exception_when_knight_wear_short_weapon() throws Exception{
        ShortWeapon shortWeapon = new ShortWeapon( "刺", 3, new RandomGenerator( random ));
        shortWeapon.setFeature( new FireFeature());

        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_FIRE - 1);
        knight.wearWeapon(shortWeapon);

    }

    @Test
    public void not_throw_exception_when_knight_wear_long_weapon(){
        LongWeapon longWeapon = new LongWeapon( "矛", 3, new RandomGenerator( random ));
        longWeapon.setFeature( new FireFeature());
        try {
            when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_FIRE - 1);
            knight.wearWeapon( longWeapon );

        }catch ( IllWeaponTypeException e ){
            fail();
        }
    }
}
