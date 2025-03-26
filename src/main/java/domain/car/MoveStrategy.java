package domain.car;

public class MoveStrategy {

    private final int CAN_MOVE = 4;

    private final RandomNumberGenerator randomNumberGenerator;

    public MoveStrategy() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public MoveStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public boolean canMove(){
        return randomNumberGenerator.getNumber() >= CAN_MOVE;
    }

}
