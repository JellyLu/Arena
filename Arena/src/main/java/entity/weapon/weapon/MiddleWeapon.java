package entity.weapon.weapon;

import entity.player.Player;
import entity.player.Soldier;
import util.Constant;
import util.IllUseWeaponException;
import util.RandomGenerator;

public class MiddleWeapon extends Weapon {

    public MiddleWeapon(String name, int bleed, RandomGenerator randomGenerator ){
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

            if( !(player instanceof Soldier)  ){

                throw new IllUseWeaponException( "只有战士可以发动中武器技能效果\n" );

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
