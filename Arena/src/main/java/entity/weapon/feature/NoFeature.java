package entity.weapon.feature;

public class NoFeature extends Feature{
    private static NoFeature Instance = new NoFeature();

    private NoFeature(){
        super();
    }

    public static NoFeature getInstance(){
        return Instance;
    }


}
