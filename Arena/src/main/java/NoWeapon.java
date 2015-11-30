public class NoWeapon extends Weapon{
    private static NoWeapon Instance = new NoWeapon( "", 0 );

    private NoWeapon( String name, int damage ){
        super( name, damage );
    }

    @Override
    public String useWeapon(){
        return "";
    }

    public static NoWeapon getInstance(){
        return Instance;
    }
}
