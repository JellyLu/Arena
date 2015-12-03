package entity.weapon.feature;

import entity.weapon.damage.Damage;
import util.Constant;

public class PoisonFeature extends Feature{

    public PoisonFeature(){
        super();
    }

    public int getDamageTimes(){
        return Constant.FEATURE_DAMAGE_TIMES_POISON;
    }

    public int getDamageType(){
        return Constant.DAMAGE_TYPE_LOSE_BLEED;
    }

     public String getName(){
         return Constant.FEATURE_POISON;
     }

     public String getFeatureType(){
        return Constant.FEATURE_TYPE_POISON;
     }

    @Override
     public String featureEffect() {

        super.featureEffect();
        return "中毒了";
     }

     public Damage getDamage(){
        Damage damage = super.getDamage();
        damage.setBleed( Constant.FEATURE_DAMAGE_POISON );
        return damage;
    }

}
