public class MainClass {
    public static void main( String[] args){
        Soldier  soldier  = new Soldier( "lu", 20, 5 );
        soldier.wearArmor( new Armor( "金丝软甲", 4));
        soldier.wearWeapon( new Weapon( "刀", 3) );
        Player   player   = new Player( "yang", 18, 10 );
        PlayGame playGame = new PlayGame( new ConsoleLog() );
        playGame.playGame( soldier, player );
    }
}
