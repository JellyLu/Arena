import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    @Test
    public void should_create_player_successful(){
        Player player = new Player( "lu", 20, 3 );

        assertThat( player.getName(), is( "lu" ) );
        assertThat( player.getLifeCount(), is( 20 ));
        assertThat( player.getDamage(), is( 3 ));

    }

    @Test
    public void should_player_is_alive_when_life_count_bigger_than_0(){
        Player player = new Player( "lu", 20, 3 );

        assertThat( player.isAlive(), is(true));
    }

    @Test
    public void should_player_is_alive_when_life_count_equal_t0_0(){
        Player player = new Player( "lu", 0, 3 );

        assertThat( player.isAlive(), is(true));
    }

    @Test
    public void should_player_is_dead_when_life_count_less_than_0(){
        Player player = new Player( "lu", -2, 3 );
        assertThat( player.isAlive(), is(false));
    }

    @Test
    public void should_player_role_is_people(){
        Player player = new Player( "lu", -2, 3 );
        assertThat( player.getRole(), is( "普通人" ));
    }

    @Test
    public void should_player_whole_damage_equal_to_damage(){
        Player player = new Player( "lu", -2, 3 );
        assertThat( player.getDamage(), is(player.getDamage()));
    }


    @Test
    public void should_beat_other(){
        Player attacker = new Player( "lu", 20, 5 );
        Player victim   = new Player( "yang", 20, 4 );
        attacker.beat( victim );
        assertThat( victim.getLifeCount(), is( 20 - attacker.getDamage() ));
    }

    @Test
    public void should_return_who_beat_vicitm_and_how_much_life_count_victim_left(){
        Player attacker = new Player( "lu", 20, 5 );
        Player victim   = new Player( "yang", 20, 4 );

        assertThat( attacker.beat( victim ), is( "普通人lu攻击了普通人yang,yang受到了5点伤害,yang剩余生命值:15\n" ) );
    }

    @Test
    public void player_beat_soldier_when_soldier_without_weapon_and_armor() {
        Player  player  = new Player( "yang", 100, 10 );
        Soldier soldier = new Soldier( "lu", 80, 20 );

        assertThat( player.beat( soldier ), is("普通人yang攻击了战士lu,lu受到了10点伤害,lu剩余生命值:70\n"));

    }

    @Test
    public void player_beat_soldier_when_soldier_with_armor() {
        Player  player  = new Player( "yang", 100, 10 );
        Soldier soldier = new Soldier( "lu", 80, 20 );
        Armor   armor   = new Armor("盾", 5);
        soldier.wearArmor(armor);

        assertThat( player.beat(soldier), is("普通人yang攻击了战士lu,lu用盾防御,lu受到了5点伤害,lu剩余生命值:75\n"));
    }


}
