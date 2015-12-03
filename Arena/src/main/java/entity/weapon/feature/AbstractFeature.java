package entity.weapon.feature;

import entity.weapon.damage.Damage;

public abstract class AbstractFeature {
    protected int    lastAttackCount;
    protected Damage damage;

    public AbstractFeature(){
        damage = new Damage();
    }

    public int getLastAttackCount(){
        return lastAttackCount;
    }

    public void setLastAttackCount( int lastAttackCount ){
        this.lastAttackCount = lastAttackCount;
    }

    public void increaseLastAttackCount(){
        ++lastAttackCount;
        damage.setLastAttackCount( lastAttackCount );
    }

    public void decreaseLastAttackCount(){
        if ( lastAttackCount > 0 ) {
            --lastAttackCount;
            damage.setLastAttackCount( lastAttackCount );
        }
    }

    public boolean isHarmful(){
        return getLastAttackCount()>0?true:false;
    }

    abstract String  getFeatureType();
    abstract String  getName();
    abstract String  featureEffect();
    abstract boolean isLogLastAttackCount();
    abstract Damage  getDamage();
    abstract void    useFeature( boolean lastTimeIsUseFeature );
}
