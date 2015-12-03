package entityTest.weaponTest.featureTest;

import entity.weapon.feature.DizzyFeature;
import org.junit.Test;
import util.Constant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DizzyFeatureTest {
    @Test
    public void test_get_name(){
        assertThat( new DizzyFeature().getName(), is( "晕" ));
    }

    @Test
    public void test_default_last_attack_count(){
        assertThat( new DizzyFeature().getLastAttackCount(), is( Constant.FEATURE_DAMAGE_TIMES_DIZZY ));
    }


    @Test
    public void test_damage_type_equal_to_default(){
        assertThat( new DizzyFeature().getDamageType(), is( Constant.DAMAGE_TYPE_CAN_NOT_ATTACK_TWICE  ));
    }

    @Test
    public void test_feature_type(){
        assertThat( new DizzyFeature().getFeatureType(), is( "眩晕伤害" ));
    }

    @Test
    public void test_feature_effect(){
        assertThat( new DizzyFeature().featureEffect(), is( "晕倒了" ) );
    }
}
