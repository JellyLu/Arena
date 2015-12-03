package entityTest.weaponTest.featureTest;

import entity.weapon.feature.AllEffortFeature;
import org.junit.Test;
import util.Constant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AllEffortFeatureTest {

    @Test
    public void test_get_name(){
        assertThat( new AllEffortFeature().getName(), is( "" ));
    }

    @Test
    public void test_default_last_attack_count(){
        assertThat( new AllEffortFeature().getLastAttackCount(), is( Constant.FEATURE_DAMAGE_TIMES_ALL_EFFORT ));
    }


    @Test
    public void test_damage_type_equal_to_default(){
        assertThat( new AllEffortFeature().getDamageType(), is( Constant.DAMAGE_TYPE_TRIPLE_DAMAGE  ));
    }

    @Test
    public void test_feature_type(){
        assertThat( new AllEffortFeature().getFeatureType(), is( "全力一击" ));
    }

    @Test
    public void test_feature_effect(){
        assertThat( new AllEffortFeature().featureEffect(), is( "发动了全力一击" ) );
    }
}
