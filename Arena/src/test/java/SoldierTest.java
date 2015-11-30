import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SoldierTest {

    private Soldier soldier;
    private Player  player;
    private Armor   armor;
    private Weapon  weapon;

    @Before
    public void setUp(){
        soldier = new Soldier( "lu", 20, 11 );
        player  = new Player( "yang", 20, 10 );
        armor   = new Armor( "盾", 4 );
        weapon  = new Weapon( "矛", 3 );
    }

    @Test
    public void should_soldier_beat_player_without_weapon_and_armor(){
        assertThat( soldier.beat( player ), is("战士lu攻击了普通人yang,yang受到了11点伤害,yang剩余生命值:9\n") );
    }

    @Test
    public void should_soldier_beat_player_with_weapon_without_armor(){
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
        int oldDamage = soldier.getDamage();
        soldier.wearArmor( armor );

        assertThat( soldier.getDamage(), is( oldDamage ));
    }

    @Test
    public void should_damage_increase_after_soldier_wear_weapon(){
        int oldDamage = soldier.getDamage();
        soldier.wearWeapon( weapon );

        assertThat( soldier.getDamage(), is( oldDamage + weapon.getDamage() ));
    }
}
