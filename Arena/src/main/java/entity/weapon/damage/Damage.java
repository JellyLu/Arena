package entity.weapon.damage;

import util.Constant;

public class Damage {

    private int bleed;// = 0;
    private int cannotDamageTimes;// = 0;
    private int damageType;//= Constant.DAMAGE_TYPE_NO_DAMAGE;
    private int beMultipleDamaged;// = 1; //被攻击的伤害倍数
    private int damageTimes;// = 0;

    private int lastAttackCount;

    public Damage(){
        this.bleed = 0;
        this.cannotDamageTimes = 0;
        this.damageType = Constant.DAMAGE_TYPE_NO_DAMAGE;
        this.beMultipleDamaged = 1;
        this.damageTimes = 0;
        this.lastAttackCount = 0;
    }

    public int getDamageTimes() {
        return damageTimes;
    }

    public void setDamageTimes(int damageTimes) {
        this.damageTimes = damageTimes;
    }



    public int getBeMultipleDamaged() {
        return beMultipleDamaged;
    }

    public void setBeMultipleDamaged(int beMultipleDamaged) {
        this.beMultipleDamaged = beMultipleDamaged;
    }

    public int getDamageType(){
        return this.damageType;
    }

    public void setDamageType( int damageType ){
        this.damageType = damageType;
    }

    public int  getBleed(){
        return this.bleed;
    }
    public void setBleed( int bleed ){
        this.bleed = bleed;
    }

    public int getCannotDamageTimes(){
        return this.cannotDamageTimes;
    }
    public void setCannotDamageTimes( int cannotDamageTimes ){
        this.cannotDamageTimes = cannotDamageTimes;
    }

    public int getLastAttackCount() {
        return lastAttackCount;
    }

    public void setLastAttackCount(int lastAttackCount) {
        this.lastAttackCount = lastAttackCount;
    }

}
