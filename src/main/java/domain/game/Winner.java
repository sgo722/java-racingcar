package domain.game;

import domain.car.Car;
import domain.car.Cars;

import java.util.ArrayList;

public class Winner implements Result{
    // 결과를 판단한다(우승자를 판단한다)

    private ArrayList<Car> winners;

    public Winner() {
        winners = new ArrayList<>();
    }

    private Winner(ArrayList<Car> winners) {
        this.winners = winners;
    }

    public void judge(Cars cars){
        int maxMoveCount = 0;
        for (Car car : cars.getCars()) {
            int currentCarMoveCount = car.getMoveCount();
            if(maxMoveCount < currentCarMoveCount){
                winners = new ArrayList<>();
                winners.add(car);
                maxMoveCount = currentCarMoveCount;
            }else if(maxMoveCount == currentCarMoveCount){
                winners.add(car);
            }
        }
    }

    public ArrayList<String> getCarNames() {
        ArrayList<String> carNames = new ArrayList<>();
        for (Car car : winners) {
            System.out.println(winners);
            carNames.add(car.getName());
        }
        return carNames;
    }
}
