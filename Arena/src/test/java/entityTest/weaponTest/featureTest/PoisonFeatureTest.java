package entityTest.weaponTest.featureTest;

import entity.weapon.feature.PoisonFeature;
import org.junit.Test;
import util.Constant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PoisonFeatureTest {

    @Test
    public void test_get_name(){
        assertThat( new PoisonFeature().getName(), is( "毒" ));
    }

    @Test
    public void test_default_last_attack_count(){
        assertThat( new PoisonFeature().getLastAttackCount(), is( Constant.FEATURE_DAMAGE_TIMES_POISON ));
    }


    @Test
    public void test_damage_type_equal_to_default(){
        assertThat( new PoisonFeature().getDamageType(), is( Constant.DAMAGE_TYPE_LOSE_BLEED  ));
    }

    @Test
    public void test_feature_type() {
        assertThat(new PoisonFeature().getFeatureType(), is("毒性伤害"));
    }

    @Test
    public void test_feature_effect(){
        assertThat( new PoisonFeature().featureEffect(), is( "中毒了" ) );
    }
}
