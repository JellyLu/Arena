import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.inOrder;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PlayGameTest {

    private  PlayGame   playGame;
    @Mock
    private  ConsoleLog consoleLog;
    InOrder    inOrder;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        inOrder    = inOrder( consoleLog );
        playGame   = new PlayGame( consoleLog );
    }

    @Test
    public void should_play_game_victim_lose_when_attacker_is_powerful(){
        Player attacker = new Player( "lu", 20, 20 );
        Player victim   = new Player( "yang", 18, 10 );

        playGame.playGame( attacker, victim);

        inOrder.verify( consoleLog, times(1)).log( "普通人lu攻击了普通人yang,yang受到了20点伤害,yang剩余生命值:-2\n" );
        inOrder.verify( consoleLog, times(1)).log( "yang被打败了\n" );
    }

    @Test
    public void should_play_game_victim_win_when_attacker_is_not_powerful(){
        Player attacker = new Player( "lu", 12, 10 );
        Player victim   = new Player( "yang", 20, 10 );

        playGame.playGame( attacker, victim);

        inOrder.verify( consoleLog, times(1)).log( "普通人lu攻击了普通人yang,yang受到了10点伤害,yang剩余生命值:10\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人yang攻击了普通人lu,lu受到了10点伤害,lu剩余生命值:2\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人lu攻击了普通人yang,yang受到了10点伤害,yang剩余生命值:0\n" );
        inOrder.verify( consoleLog, times(1)).log( "普通人yang攻击了普通人lu,lu受到了10点伤害,lu剩余生命值:-8\n" );
        inOrder.verify( consoleLog, times(1)).log( "lu被打败了\n" );
    }


}
