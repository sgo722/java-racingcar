package domain.car;

public class MoveCount {
    // 조건에 맞춰 움직인다.
    // moveCount라는 속성과 이를 관리하는 행동을 가짐으로써 움직인다고 했을 떄 이 메서드만 바꿔도된다.
    private final int moveCount;
    private final MoveStrategy moveStrategy;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
        this.moveStrategy = new MoveStrategy();
    }

    public MoveCount move(){
        if(moveStrategy.canMove()){
            return new MoveCount(moveCount + 1);
        }

        return this;
    }

    public int getMoveCount(){
        return moveCount;
    }
}
