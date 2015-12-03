package entity.player;

import entity.weapon.damage.Damage;
import entity.weapon.damage.NoDamage;
import util.Constant;
import util.IllUseWeaponException;

public class Player implements Role {

    protected int     bleed; //攻击力
    private   int     lifeCount; //生命值
    private   String  name;//名字
    private   boolean attackState = true;//是否能攻击
    protected Damage  damage;
    protected String  damageEffect;
    protected String  damageType;
    private   int     cannotAttackTimes = 0;
    protected boolean isUseFeature = false;

    public Player( String name, int lifeCount, int bleed ){
        this.name       = name;
        this.lifeCount  = lifeCount;
        this.bleed      = bleed;
        this.damage     = NoDamage.getInstance();
        this.damageType = "";
    }

    public String getDamageType() {
        return damageType;
    }

    public void setCannotAttackTimes(int cannotAttackTimes) {
        this.cannotAttackTimes = cannotAttackTimes;
    }

    public int getCannotDamageTimes() {
        return cannotAttackTimes;
    }

    public String getDamageEffect() {
        return damageEffect;
    }

    public int getBleed() {
        return bleed;
    }

    public boolean getAttackState(){
        attackState = cannotAttackTimes > 0 ? Constant.ATTACK_STATE_OFF : Constant.ATTACK_STATE_ON;
        return attackState;
    }

    public String getAttackStateLogString( boolean attackState ){
        return attackState ? "":"无法攻击,";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    public boolean isAlive(){
        return  lifeCount >= 0;
    }

    public String playerIdentifier() throws IllUseWeaponException{
        return String.format( "%s%s", getRole(), name);
    }

    public String beAttackedPlayerIdentifier() throws IllUseWeaponException{
        return String.format( "%s%s", getRole(), name);
    }


    public String getRole(){
        return Constant.ROLE_CIVVY;
    }

    public int getLifeCount(){
        return lifeCount;
    }

    public String beat( Player other )throws IllUseWeaponException {
        return String.format( "%s攻击了%s,%s", playerIdentifier(), other.beAttackedPlayerIdentifier(), other.beAttacked( this ) );
    }

    public String beAttacked(Player attacker ){
        int loseLifeCount = loseLifeCount( attacker.getBleed() );
        lifeCount -= loseLifeCount;
        if ( !attacker.isUseFeature ){
            return String.format( "%s受到了%d点伤害,%s剩余生命值:%d\n", name, loseLifeCount, name, lifeCount);
        }else {
            return resultString( attacker, loseLifeCount);
        }

    }

    public int loseLifeCount( int bleed ){
        return bleed;
    }

    private String resultString( Player attacker, int loseLifeCount ){
        String result = "";
        switch (  attacker.getDamage().getDamageType() ){
            case Constant.DAMAGE_TYPE_LOSE_BLEED:
                result = String.format( "%s受到了%d点伤害,%s%s,%s剩余生命值:%d\n", name, loseLifeCount,name, attacker.getDamageEffect(), name, lifeCount);
                lifeCount -= attacker.getDamage().getBleed();
                result += String.format("%s受到了%d点%s,%s剩余生命值:%d\n", name,attacker.getDamage().getBleed(), attacker.getDamageType(), name, lifeCount);
                break;

            case  Constant.DAMAGE_TYPE_CAN_NOT_ATTACK_TWICE:
                cannotAttackTimes = attacker.getDamage().getCannotDamageTimes();
                result = String.format( "%s受到了%d点伤害,%s%s,%s剩余生命值:%d\n", name, loseLifeCount, name, attacker.getDamageEffect(),  name, lifeCount);
                result += String.format("%s%s,%s眩晕还剩:%d轮\n", name, attacker.getDamageEffect(), getAttackStateLogString(attackState),attacker.getDamage().getLastAttackCount() );
                break;

            case Constant.DAMAGE_TYPE_TWICE_CAN_NOT_ATTACK_ONCE:
                cannotAttackTimes = attacker.getDamage().getCannotDamageTimes();
                result = String.format( "%s受到了%d点伤害,%s%s,%s剩余生命值:%d\n", name, loseLifeCount, name, attacker.getDamageEffect(),  name, lifeCount);
                break;

            case Constant.DAMAGE_TYPE_TRIPLE_DAMAGE:
                lifeCount = lifeCount + loseLifeCount;
                loseLifeCount = loseLifeCount*attacker.damage.getBeMultipleDamaged();
                lifeCount -= loseLifeCount;
                result = String.format("%s%s,%s受到了%d点伤害,%s剩余生命值:%d\n", attacker.getName(), attacker.getDamageEffect(), name, loseLifeCount, name, lifeCount);
                break;

            case Constant.DAMAGE_TYPE_NO_DAMAGE:
                result = String.format( "%s受到了%d点伤害,%s剩余生命值:%d\n", name, loseLifeCount, name, lifeCount);
                break;

            default:
                result = String.format( "%s受到了%d点伤害,%s剩余生命值:%d\n", name, loseLifeCount, name, lifeCount);
                break;
        }
        return result;
    }

}
