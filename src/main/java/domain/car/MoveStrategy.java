package domain.car;

public class MoveStrategy {

    private final int CAN_MOVE = 4;

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public boolean canMove(){
        if (randomNumberGenerator.getNumber() >= CAN_MOVE) {
            return true;
        }
        return false;
    }

}
