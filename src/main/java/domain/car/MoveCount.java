package domain.car;

public class MoveCount {

    // 조건에 맞춰 움직인다.
    // moveCount라는 속성과 이를 관리하는 행동을 가짐으로써 움직인다고 했을 떄 이 메서드만 바꿔도된다.
    private final int CAN_MOVE = 4;

    private final int moveCount;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public MoveCount(){
        this.moveCount = 0;
    }

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public MoveCount move(){
        if (randomNumberGenerator.getNumber() >= CAN_MOVE) {
            return new MoveCount(this.moveCount + 1);
        }
        return this;
    }

    public int getCount(){
        return moveCount;
    }
}
