public class Soldier extends Player {

    private Weapon weapon;
    private Armor  armor;

    @Override
    public String getRole(){
        return "战士";
    }

    public Soldier( String name, int lifeCount, int damage ){
        super( name, lifeCount, damage );
        weapon = NoWeapon.getInstance();
        armor  = NoArmor.getInstance();
    }

    @Override
    public String playerIdentifier( ){
        return String.format( "%s%s", super.playerIdentifier(), weapon.useWeapon() );
    }

    @Override
    public String beBeatedPlayerIdentifier( ){
        String result = super.playerIdentifier();
        if ( armor.getDefenceDamage() != 0 ){
            result += String.format( ",%s%s", getName(), armor.useArmor() );
        }
        return result;
    }

    @Override
    public int loseLifeCount( int damamge ){
        return  damamge - armor.getDefenceDamage();
    }

    public void wearWeapon( Weapon weapon ){
        this.weapon = weapon;
        this.damage += weapon.getDamage();
    }

    public void wearArmor( Armor armor ){
        this.armor = armor;
    }

}
