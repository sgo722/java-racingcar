package domain.car;

public class Car {
    // 이름을 가진다.
    // 전진한다.

    private final Name name;
    private final MoveCount moveCount;

    public Car(Name name){
        this.name = name;
        this.moveCount = new MoveCount(0);
    }

    public Car(Name name, MoveCount moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public Car move(){
        return new Car(this.name, moveCount.move());
    }

    public int getMoveCount() {
        return moveCount.getMoveCount();
    }

    public String getName() {
        return name.getName();
    }
}
