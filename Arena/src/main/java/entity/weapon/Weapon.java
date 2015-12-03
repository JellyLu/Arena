package entity.weapon;

import entity.weapon.damage.Damage;
import entity.weapon.damage.NoDamage;
import entity.weapon.feature.Feature;
import entity.weapon.feature.NoFeature;
import util.RandomGenerator;

public class Weapon {
    private String  name;
    private Damage  featureDamage;
    private String  featureEffect;
    private int     bleed;
    private Feature feature;
    private boolean isUseFeature = false;
    private RandomGenerator randomGenerator;

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

    public Weapon(String name, int bleed, RandomGenerator randomGenerator ){
        this.name            = name;
        this.bleed           = bleed;
        this.feature         = NoFeature.getInstance();
        this.featureDamage   = NoDamage.getInstance();
        this.featureEffect   = feature.featureEffect();
        this.randomGenerator = randomGenerator;
    }

    public String useWeapon(){

        int probability  = feature.getDamage().getDamageType();
        int randomNumber = randomGenerator.generateRandomNumber();

        if ( randomNumber < probability  && feature.isHarmful()  ){
            String result = useFeature();
            isUseFeature  = true;
            return result;
        }else {
            isUseFeature  = false;
            return String.format( "用%s", name );
        }
    }

    private String useFeature(){
        feature.useFeature( isUseFeature );
        featureDamage.setLastAttackCount( feature.getLastAttackCount() );
        return String.format( "用%s%s", feature.getName(), name  );
    }

}
