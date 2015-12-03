package main;


import entity.player.Player;
import entity.player.Soldier;
import entity.weapon.Weapon;
import entity.weapon.feature.PoisonFeature;
import game.PlayGame;
import util.ConsoleLog;
import util.Constant;
import util.RandomGenerator;

import java.util.Random;


public class MainClass {

    public static void main( String[] args){

        Soldier soldier  = new Soldier( "张三", 20, 5 );
      //  soldier.wearArmor( new Armor( Constant.ARMOR_GOLDSOFT, 4));

        Weapon weapon = new Weapon( Constant.WEAPON_SWORD, 3, new RandomGenerator( new Random() ));
        weapon.setFeature( new PoisonFeature() );
      //  weapon.setFeature( new DizzyFeature() );
       // weapon.setFeature( new AllEffortFeature() );
        soldier.wearWeapon(  weapon );

        Player player   = new Player( "李四", 20, 8 );

        PlayGame playGame = new PlayGame( new ConsoleLog() );
        playGame.playGame( soldier, player );
    }

}
