public class PlayGame {

    private ConsoleLog consoleLog;

    public  PlayGame( ConsoleLog consoleLog ){
        this.consoleLog = consoleLog;
    }

    public void playGame( Player playerA, Player playerB ){
        Player attacker = playerA;
        Player viticm   = playerB;
        Player loser    = attacker;

        while ( attacker.isAlive() ){
            consoleLog.log( attacker.beat( viticm ) );
            loser = viticm;
            viticm = attacker;
            attacker = loser;
        }

        consoleLog.log( String.format("%s被打败了\n", loser.getName()));
    }
}
