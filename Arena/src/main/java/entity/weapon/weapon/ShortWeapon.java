package entity.weapon.weapon;

import entity.player.Assassin;
import entity.player.Player;
import util.Constant;
import util.IllUseWeaponException;
import util.RandomGenerator;

public class ShortWeapon extends Weapon {

    public ShortWeapon(String name, int bleed, RandomGenerator randomGenerator ){
        super( name, bleed, randomGenerator);
    }

    public String getRole() {
        return Constant.ROLE_MIDDLE;
    }

    @Override
    public String useWeapon( Player player ) throws IllUseWeaponException {

        int probability  = feature.getDamage().getDamageType();
        int randomNumber = randomGenerator.generateRandomNumber();

        if ( randomNumber < probability  && feature.isHarmful()  ) {

            if ( !(player instanceof Assassin) ){

                throw new IllUseWeaponException( "只有刺客可以发动短武器技能效果\n" );

            }else {

                String result = useFeature();
                isUseFeature = true;
                return result;
            }
        }else {

            isUseFeature  = false;
            return String.format( "用%s", name );
        }
    }



}
