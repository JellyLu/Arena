package entity.weapon.damage;

public class NoDamage extends  Damage {
    public static NoDamage Instance = new NoDamage();
    private NoDamage(){
        super();
    }

    public static NoDamage getInstance(){
        return Instance;
    }

}
