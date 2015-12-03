package entity.weapon.weapon;

import entity.player.Player;
import entity.player.Role;
import entity.weapon.damage.Damage;
import entity.weapon.damage.NoDamage;
import entity.weapon.feature.Feature;
import entity.weapon.feature.NoFeature;
import util.Constant;
import util.IllUseWeaponException;
import util.RandomGenerator;

public class Weapon implements Role{
    protected String  name;
    private Damage  featureDamage;
    private String  featureEffect;
    private   int     bleed;
    protected Feature feature;
    protected boolean isUseFeature = false;
    protected RandomGenerator randomGenerator;

    public Weapon(String name, int bleed, RandomGenerator randomGenerator ){
        this.name            = name;
        this.bleed           = bleed;
        this.feature         = NoFeature.getInstance();
        this.featureDamage   = NoDamage.getInstance();
        this.featureEffect   = feature.featureEffect();
        this.randomGenerator = randomGenerator;
    }

    public boolean isUseFeature() {
        return isUseFeature;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {

        this.feature       = feature;
        this.featureDamage = feature.getDamage();
        this.featureEffect = feature.featureEffect();
    }

    public String getFeatureEffect() {
        return featureEffect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Damage getFeatureDamage() {
        return featureDamage;
    }

    public int getBleed(){
        return bleed;
    }



    public String useWeapon( Player player ) throws IllUseWeaponException{

        int probability  = feature.getDamage().getDamageType();
        int randomNumber = randomGenerator.generateRandomNumber();

        if ( randomNumber < probability  && feature.isHarmful()  ) {

                String result = useFeature();
                isUseFeature = true;
                return result;
        }else {

            isUseFeature  = false;
            return String.format( "用%s", name );
        }
    }

    protected String useFeature(){
        feature.useFeature( isUseFeature );
        featureDamage.setLastAttackCount( feature.getLastAttackCount() );
        return String.format( "用%s%s", feature.getName(), name  );
    }

    @Override
    public String getRole() {
        return Constant.ROLE_DEFAULT;
    }
}
