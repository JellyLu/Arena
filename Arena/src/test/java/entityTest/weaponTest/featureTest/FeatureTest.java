package entityTest.weaponTest.featureTest;

import entity.weapon.feature.Feature;
import org.junit.Test;
import util.Constant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FeatureTest {

    @Test
    public void should_get_name_return_empty_string(){
        assertThat( new Feature().getName(), is( "" ));
    }

    @Test
    public void should_last_attack_count_equal_to_0(){
        assertThat( new Feature().getLastAttackCount(), is( Constant.FEATURE_DAMAGE_TIMES_DEFAULT ));
    }

    @Test
    public void should_last_attack_count_increase_while_last_time_use_feature(){
        Feature feature = new Feature();
        int oldLastAttackCount = feature.getLastAttackCount();
        feature.useFeature( true );
        assertThat( feature.getLastAttackCount(), is( oldLastAttackCount + 1 ));
    }

    @Test
    public void should_last_attack_count_decrease_while_last_time_not_use_feature(){
        Feature feature = new Feature();
        int oldLastAttackCount = feature.getLastAttackCount();
        feature.useFeature( false );
        assertThat( feature.getLastAttackCount(), is( ( oldLastAttackCount - 1 )>0 ? oldLastAttackCount-1 : 0 ) );
    }

    @Test
    public void should_damage_type_equal_to_default(){
        assertThat( new Feature().getDamageType(), is( Constant.DAMAGE_TYPE_NO_DAMAGE ));
    }

    @Test
    public void should_feature_type_equal_to_default(){
        assertThat( new Feature().getFeatureType(), is( Constant.FEATURE_TYPE_DEFAULT ));
    }

    @Test
    public void test_feature_effect(){
        assertThat( new Feature().featureEffect(), is( "" ) );
    }

}
