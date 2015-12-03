package entity.player;

import entity.weapon.armor.Armor;
import entity.weapon.armor.NoArmor;
import entity.weapon.weapon.LongWeapon;
import entity.weapon.weapon.MiddleWeapon;
import entity.weapon.weapon.NoWeapon;
import entity.weapon.weapon.Weapon;
import util.Constant;
import util.IllUseWeaponException;
import util.IllWeaponTypeException;

public class Knight extends Player{

    private Weapon weapon;
    private Armor armor;

    public Knight(String name, int lifeCount, int bleed ){
        super( name, lifeCount, bleed );
        weapon = NoWeapon.getInstance();
        armor  = NoArmor.getInstance();
    }

    @Override
    public String getRole(){
        return Constant.ROLE_KNIGHT;
    }

    @Override
    public String beat( Player other )throws IllUseWeaponException{
        return String.format( "%s攻击了%s,%s", playerIdentifier(), other.beAttackedPlayerIdentifier(), other.beAttacked( this )  );
    }

    @Override
    public String playerIdentifier( ) throws IllUseWeaponException{
        return String.format( "%s%s", super.playerIdentifier(), useWeapon() );
    }

    @Override
    public String beAttackedPlayerIdentifier( ) throws IllUseWeaponException{
        String result = super.playerIdentifier();
        if ( armor.getDefenceDamage() != 0 ){
            result += String.format( ",%s%s", getName(), armor.useArmor() );
        }
        return result;
    }

    @Override
    public int loseLifeCount( int otherBleed ){
        return  otherBleed - armor.getDefenceDamage();
    }

    public void wearWeapon( Weapon weapon ) throws IllWeaponTypeException {

        if ( weapon instanceof LongWeapon || weapon instanceof MiddleWeapon) {

            this.weapon = weapon;
            this.damage = weapon.getFeatureDamage();
            this.damageEffect = weapon.getFeatureEffect();
            this.bleed += weapon.getBleed();
            this.damageType = weapon.getFeature().getFeatureType();
        }else {
            throw new IllWeaponTypeException( "骑士只可以装备中长武器" );
        }
    }

    public void wearArmor( Armor armor ){
        this.armor = armor;
    }

    private String useWeapon() throws IllUseWeaponException {
        String string = weapon.useWeapon(this);
        isUseFeature = weapon.isUseFeature();
        return string;
    }

}
