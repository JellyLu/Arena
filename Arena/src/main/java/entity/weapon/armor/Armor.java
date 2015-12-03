package entity.weapon.armor;

public class Armor {
    private String name;
    private int    defenceDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefenceDamage() {
        return defenceDamage;
    }

    public void setDenfenceDamage(int denfenceDamage) {
        this.defenceDamage = denfenceDamage;
    }

    public String useArmor(){
        return String.format( "用%s防御", name );
    }

    public Armor( String name, int defenceDamage ){
        this.name = name;
        this.defenceDamage = defenceDamage;
    }

}
