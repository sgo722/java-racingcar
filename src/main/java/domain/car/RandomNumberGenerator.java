package domain.car;

import java.util.Random;

public class RandomNumberGenerator {
    // 랜덤한 숫자를 생성한다.
    private final int MAX_RANDOM_NUMBER = 9;

    private final Random random;

    public RandomNumberGenerator(){
        random = new Random();
    }

    public int getNumber(){
        return random.nextInt(MAX_RANDOM_NUMBER + 1);
    }
}
