package entity.player;
import entity.weapon.Armor;
import entity.weapon.NoArmor;
import entity.weapon.NoWeapon;
import entity.weapon.Weapon;
import util.Constant;

public class Soldier extends Player {

    private Weapon weapon;
    private Armor armor;

    @Override
    public String getRole(){
        return Constant.ROLE_SOLDIER;
    }

    @Override
    public int getRoleType(){
        return Constant.ROLE_TYPE_SOLDIER;
    }

    public Soldier(String name, int lifeCount, int bleed ){
        super( name, lifeCount, bleed );
        weapon = NoWeapon.getInstance();
        armor  = NoArmor.getInstance();
    }

    @Override
    public String beat( Player other ){
        return String.format( "%s攻击了%s,%s", playerIdentifier(), other.beAttackedPlayerIdentifier(), other.beAttacked( this )  );
    }

    @Override
    public String playerIdentifier( ){
        return String.format( "%s%s", super.playerIdentifier(), useWeapon() );
    }

    @Override
    public String beAttackedPlayerIdentifier( ){
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

    public void wearWeapon( Weapon weapon ){
        this.weapon = weapon;
        this.damage = weapon.getFeatureDamage();
        this.damageEffect = weapon.getFeatureEffect();
        this.bleed += weapon.getBleed();
        this.damageType = weapon.getFeature().getFeatureType();

    }

    public void wearArmor( Armor armor ){
        this.armor = armor;
    }


    private String useWeapon(){
        String string = weapon.useWeapon();
        isUseFeature = weapon.isUseFeature();
        return string;
    }

}
