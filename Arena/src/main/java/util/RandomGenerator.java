package util;

import java.util.Random;

public class RandomGenerator {
    private Random random;

    public RandomGenerator(Random random) {
        this.random = random;
    }

    public int generateRandomNumber() {

        int num = random.nextInt(Constant.RANDOM_MAX);

        return  num;
    }
}
