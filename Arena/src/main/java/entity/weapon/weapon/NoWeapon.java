package entity.weapon.weapon;

import entity.player.Player;
import util.RandomGenerator;

import java.util.Random;

public class NoWeapon extends Weapon{
    private static NoWeapon Instance = new NoWeapon( "", 0, new RandomGenerator( new Random()));

    private NoWeapon(String name, int damage, RandomGenerator randomGenerator){
        super( name, damage, randomGenerator );
    }

    @Override
    public String useWeapon(Player player){
        return "";
    }

    public static NoWeapon getInstance(){
        return Instance;
    }
}
