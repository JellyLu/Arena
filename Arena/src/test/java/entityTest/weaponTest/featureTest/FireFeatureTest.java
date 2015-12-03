package entityTest.weaponTest.featureTest;

import entity.weapon.feature.FireFeature;
import org.junit.Test;
import util.Constant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FireFeatureTest {
    @Test
    public void test_get_name(){
        assertThat( new FireFeature().getName(), is( "火" ));
    }

    @Test
    public void test_default_last_attack_count(){
        assertThat( new FireFeature().getLastAttackCount(), is( Constant.FEATURE_DAMAGE_TIMES_FIRE ));
    }


    @Test
    public void test_damage_type_equal_to_default(){
        assertThat( new FireFeature().getDamageType(), is( Constant.DAMAGE_TYPE_LOSE_BLEED  ));
    }

    @Test
    public void test_feature_type(){
        assertThat( new FireFeature().getFeatureType(), is( "火焰伤害" ));
    }

    @Test
    public void test_feature_effect(){
        assertThat( new FireFeature().featureEffect(), is( "被火烧了" ) );
    }
}
