package entity.weapon.feature;

import entity.weapon.damage.Damage;
import util.Constant;

public class FireFeature extends Feature {

    protected int getDamageTimes(){
        return Constant.FEATURE_DAMAGE_TIMES_FIRE;
    }

    public int getDamageType(){
        return Constant.DAMAGE_TYPE_LOSE_BLEED;
    }

    public String getName(){
        return Constant.FEATURE_FIRE;
    }

    public String getFeatureType(){
        return Constant.FEATURE_TYPE_FIRE;
    }

    @Override
    public String  featureEffect(){
        super.featureEffect();
        return "被火烧了";
    }


    public Damage getDamage(){
        Damage damage = super.getDamage();
        damage.setBleed( Constant.FEATURE_DAMAGE_FIRE );
        return damage;
    }
}
