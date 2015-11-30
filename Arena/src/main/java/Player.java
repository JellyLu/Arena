public class Player {

    private   String name;
    private   int    lifeCount;
    protected int    damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Player( String name, int lifeCount, int damage ){
        this.name      = name;
        this.lifeCount = lifeCount;
        this.damage    = damage;
    }

    public boolean isAlive(){
        return  lifeCount >= 0;
    }

    public String playerIdentifier(){
        return String.format( "%s%s", getRole(), name);
    }

    public String beBeatedPlayerIdentifier(){
        return String.format( "%s%s", getRole(), name);
    }


    public String getRole(){
        return "普通人";
    }

    public String beat( Player other ){
        return String.format( "%s攻击了%s,%s", playerIdentifier(), other.beBeatedPlayerIdentifier(), other.beBeated( getDamage() ) );
    }

    public String beBeated( int damage ){
        int loseLifeCount = loseLifeCount( damage );
        lifeCount -= loseLifeCount;
        return String.format( "%s受到了%d点伤害,%s剩余生命值:%d\n", name, loseLifeCount, name, lifeCount);

    }

    public int loseLifeCount( int damage ){
        return damage;
    }

}
