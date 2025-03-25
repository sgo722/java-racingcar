package domain.car;

public class Car {
    // 이름을 가진다.
    // 조건에 따라 전진한다.
    private final int CAN_MOVE = 4;

    private final Name name;
    private final MoveCount moveCount;
    private final RandomNumberGenerator randomNumberGenerator;

    public Car(Name name) {
        this.name = name;
        this.moveCount = new MoveCount(0);
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void move(){
        if (randomNumberGenerator.getNumber() >= CAN_MOVE) {
            moveCount.plusCount();
        }
    }


    public Integer getMoveCount() {
        return moveCount.getCount();
    }

    public String getName() {
        return name.getName();
    }
}
