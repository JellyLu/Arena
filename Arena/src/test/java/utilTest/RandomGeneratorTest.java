package utilTest;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomGeneratorTest {
    private util.RandomGenerator randomGenerator;
    @Before
    public void setUp() throws Exception {
        randomGenerator = new util.RandomGenerator( new Random());
    }

    @Test
    public void test_random_number_is_random_in_5_times() throws Exception {
        HashSet<Integer> randomNumbers = new HashSet<Integer>( );
        int times = 5;

        while ( times > 0 ) {
            randomNumbers.add(randomGenerator.generateRandomNumber());
            times --;
        }

        assertThat( randomNumbers.size(), is( 5 ));
    }

}
