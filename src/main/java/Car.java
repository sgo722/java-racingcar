import java.util.Random;

public class Car {

    // 이름을 가진다.
    // 조건에 따라 전진한다.

    private String name;
    private Long moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0L;
    }

    public void move(){
        if (isPossible()) {
            moveCount++;
        }
    }

    public boolean isPossible() {
        Random rand = new Random();
        return rand.nextInt(10) >= 4;
    }
}
