package entityTest.weaponTest.featureTest;

import entity.weapon.feature.IceFeature;
import org.junit.Test;
import util.Constant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IceFeatureTest {
    @Test
    public void test_get_name(){
        assertThat( new IceFeature().getName(), is( "冰雪" ));
    }

    @Test
    public void test_default_last_attack_count(){
        assertThat( new IceFeature().getLastAttackCount(), is( Constant.FEATURE_DAMAGE_TIMES_ICE ));
    }


    @Test
    public void test_damage_type_equal_to_default(){
        assertThat( new IceFeature().getDamageType(), is( Constant.DAMAGE_TYPE_TWICE_CAN_NOT_ATTACK_ONCE  ));
    }

    @Test
    public void test_feature_type(){
        assertThat( new IceFeature().getFeatureType(), is( "冰冻伤害" ));
    }

    @Test
    public void test_feature_effect(){
        assertThat( new IceFeature().featureEffect(), is( "被冻僵了" ) );
    }
}
