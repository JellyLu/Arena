package game;


import entity.player.Player;
import util.ConsoleLog;

public class PlayGame {

    private ConsoleLog consoleLog;

    public  PlayGame( ConsoleLog consoleLog ){
        this.consoleLog = consoleLog;
    }

    public void playGame(Player playerA, Player playerB ) throws Exception{
        Player attacker = playerA;
        Player victim   = playerB;
        Player loser;
        while ( attacker.isAlive() && victim.isAlive()  ){

            consoleLog.log( attacker.beat( victim ) );
            if ( victim.getAttackState() ){
                loser = victim;
                victim = attacker;
                attacker = loser;
            }else{
                victim.setCannotAttackTimes(( victim.getCannotDamageTimes() - 1) );
            }
        }

        loser = attacker.isAlive()?victim:attacker;

        consoleLog.log( String.format("%s被打败了\n", loser.getName()));
    }
}
