package entity.weapon.feature;

import entity.weapon.damage.Damage;
import util.Constant;

public class IceFeature extends Feature {

    public int getDamageType(){
        return Constant.DAMAGE_TYPE_TWICE_CAN_NOT_ATTACK_ONCE;
    }

    protected int getDamageTimes(){
        return Constant.FEATURE_DAMAGE_TIMES_ICE;
    }

    public String getName(){
        return Constant.FEATURE_ICE;
    }

    public String getFeatureType(){
        return Constant.FEATURE_TYPE_ICE;
    }

    @Override
    public String  featureEffect(){

        super.featureEffect();
        return "被冻僵了";
    }

    public Damage getDamage(){
        Damage damage = super.getDamage();
        damage.setCannotDamageTimes( Constant.FEATURE_DAMAGE_CAN_NOT_ATTACK_ONCE );
        return damage;
    }

}
