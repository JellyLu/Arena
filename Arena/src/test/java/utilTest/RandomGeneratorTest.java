package utilTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import util.Constant;
import util.RandomGenerator;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class RandomGeneratorTest {
    private RandomGenerator randomGenerator;

    @Mock
    private Random random;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks( this );
        randomGenerator = new RandomGenerator( random );
    }

    @Test
    public void test_random_number()  {

        when( random.nextInt( Constant.RANDOM_MAX ) ).thenReturn( 4 );

        assertThat( randomGenerator.generateRandomNumber(), is( 4 ));
    }

}
