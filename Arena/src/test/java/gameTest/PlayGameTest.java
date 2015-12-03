package gameTest;

import entity.player.Player;
import entity.player.Soldier;
import entity.weapon.feature.PoisonFeature;
import entity.weapon.weapon.MiddleWeapon;
import game.PlayGame;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import util.ConsoleLog;
import util.Constant;
import util.RandomGenerator;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PlayGameTest {
    private PlayGame playGame;
    @Mock
    private ConsoleLog consoleLog;
    InOrder inOrder;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        inOrder    = Mockito.inOrder( consoleLog );
        playGame   = new PlayGame( consoleLog );
    }

    @Test
    public void should_play_game_victim_lose_when_attacker_is_powerful() throws Exception{
        Player attacker = new Player( "lu", 20, 20 );
        Player victim   = new Player( "yang", 18, 10 );

        playGame.playGame( attacker, victim);

        inOrder.verify( consoleLog, times(1)).log( "普通人lu攻击了普通人yang,yang受到了20点伤害,yang剩余生命值:-2\n" );
        inOrder.verify( consoleLog, times(1)).log( "yang被打败了\n" );
    }

    @Test
    public void should_play_game_victim_win_when_attacker_is_not_powerful() throws Exception{
        Player attacker = new Player( "lu", 12, 10 );
        Player victim   = new Player( "yang", 20, 10 );

        playGame.playGame( attacker, victim);

        inOrder.verify( consoleLog, times(1)).log( "普通人lu攻击了普通人yang,yang受到了10点伤害,yang剩余生命值:10\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人yang攻击了普通人lu,lu受到了10点伤害,lu剩余生命值:2\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人lu攻击了普通人yang,yang受到了10点伤害,yang剩余生命值:0\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人yang攻击了普通人lu,lu受到了10点伤害,lu剩余生命值:-8\n" );
        inOrder.verify( consoleLog, times(1)).log( "lu被打败了\n" );
    }

    @Test
    public void should_play_game_soldier_win_when_soldier_use_weapon_without_feature() throws Exception{
        Soldier attacker = new Soldier(  "张三", 20, 5 );
        MiddleWeapon  weapon   = new MiddleWeapon(  "剑", 3, new RandomGenerator( new Random() ));

        attacker.wearWeapon( weapon );
        Player victim    = new Player(  "李四", 20, 8 );

        playGame.playGame( attacker, victim);

        inOrder.verify( consoleLog, times(1)).log( "战士张三用剑攻击了普通人李四,李四受到了8点伤害,李四剩余生命值:12\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人李四攻击了战士张三,张三受到了8点伤害,张三剩余生命值:12\n" );
        inOrder.verify( consoleLog, times(1)).log( "战士张三用剑攻击了普通人李四,李四受到了8点伤害,李四剩余生命值:4\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人李四攻击了战士张三,张三受到了8点伤害,张三剩余生命值:4\n" );
        inOrder.verify( consoleLog, times(1)).log( "战士张三用剑攻击了普通人李四,李四受到了8点伤害,李四剩余生命值:-4\n" );
        inOrder.verify( consoleLog, times(1)).log( "李四被打败了\n" );
    }

    @Test
    public void should_play_game_soldier_win_when_soldier_use_weapon_wit_poison_feature() throws Exception{
        Player victim    = new Player(  "李四", 20, 8 );
        Soldier attacker = new Soldier(  "张三", 20, 6 );
        Random random    = mock( Random.class );
        MiddleWeapon  weapon   = new MiddleWeapon(  "剑", 3, new RandomGenerator( random ) );
        weapon.setFeature( new PoisonFeature() );

        attacker.wearWeapon(weapon);
        playGame.playGame(attacker, victim);
        when(random.nextInt(Constant.RANDOM_MAX)).thenReturn(Constant.FEATURE_DAMAGE_TIMES_POISON - 1);

        inOrder.verify(consoleLog, times(1)).log("战士张三用毒剑攻击了普通人李四,李四受到了9点伤害,李四中毒了,李四剩余生命值:11\n" +
                    "李四受到了2点毒性伤害,李四剩余生命值:9\n");
        inOrder.verify(consoleLog, times(1)).log("普通人李四攻击了战士张三,张三受到了8点伤害,张三剩余生命值:12\n");
    }


}
