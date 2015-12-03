package entity.weapon.feature;

import entity.weapon.damage.Damage;
import util.Constant;

public class AllEffortFeature extends Feature {

    public int getDamageType(){
        return Constant.DAMAGE_TYPE_TRIPLE_DAMAGE;
    }

    protected int getDamageTimes(){
        return Constant.FEATURE_DAMAGE_TIMES_ALL_EFFORT;
    }

    public String getName(){
        return Constant.FEATURE_ALL_EFFORT;
    }

    public String getFeatureType(){
        return Constant.FEATURE_TYPE_ALL_EFFORT;
    }

    @Override
    public String  featureEffect(){
        return "发动了全力一击";
    }

    public Damage getDamage(){
        Damage damage = super.getDamage();
        damage.setBeMultipleDamaged( 3 );
        return damage;
    }

}
