import java.util.Random;

public class Car {

    // 이름을 가진다.
    // 조건에 따라 전진한다.

    private final String name;
    private final Count moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = new Count(0);
    }

    public void move(){
        if (isPossible()) {
            moveCount.plusCount();
        }
    }

    public boolean isPossible() {
        Random rand = new Random();
        return rand.nextInt(10) >= 4;
    }

    public Integer getMoveCount() {
        return moveCount.getCount();
    }

    public String getName() {
        return name;
    }

    public void printCarStatus(){
        System.out.print(name + " : ");
        for(int i = 0; i < getMoveCount(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
