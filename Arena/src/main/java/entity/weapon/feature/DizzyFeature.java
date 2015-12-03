package entity.weapon.feature;

import entity.weapon.damage.Damage;
import util.Constant;

public class DizzyFeature extends Feature{

    public DizzyFeature(){
        super();
    }

    public int getDamageType(){
        return Constant.DAMAGE_TYPE_CAN_NOT_ATTACK_TWICE;
    }

    protected int getDamageTimes(){
        return Constant.FEATURE_DAMAGE_TIMES_DIZZY;
    }

    public String getName(){
        return Constant.FEATURE_DIZZY;
    }

    public String getFeatureType(){
        return Constant.FEATURE_TYPE_DIZZY;
    }

    @Override
    public String  featureEffect(){
        super.featureEffect();
        return  "晕倒了";
    }

    public boolean isLogLastAttackCount(){
        return true;
    }

    public Damage getDamage(){
        Damage damage = super.getDamage();
        damage.setCannotDamageTimes( Constant.FEATURE_DAMAGE_CAN_NOT_ATTACK_TWICE );

        return damage;
    }
}
