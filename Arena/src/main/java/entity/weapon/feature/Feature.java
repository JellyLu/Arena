package entity.weapon.feature;

import entity.weapon.damage.Damage;
import util.Constant;

public class Feature extends AbstractFeature {

    public Feature(){
        super();
        this.lastAttackCount = getDamageTimes();
        this.damage = new Damage();
        this.damage.setLastAttackCount( this.lastAttackCount );
    }

    public int getDamageType(){
        return Constant.DAMAGE_TYPE_NO_DAMAGE;
    }

    protected int getDamageTimes(){
        return Constant.FEATURE_DAMAGE_TIMES_DEFAULT;
    }

    @Override
    public String  getFeatureType(){
        return Constant.FEATURE_TYPE_DEFAULT;
    }

    public String getName(){
        return "";
    }

    @Override
    public String  featureEffect(){
        return "";
    }

    @Override
    public boolean isLogLastAttackCount(){
        return false;
    }

    public Damage  getDamage(){
        damage.setDamageType( getDamageType() );
        damage.setDamageTimes( getDamageTimes() );
        return damage;
    }

    @Override
    public void useFeature( boolean lastTimeIsUseFeature ) {
        if (lastTimeIsUseFeature){
            increaseLastAttackCount();
        }else {
            decreaseLastAttackCount();
        }
    }
}
