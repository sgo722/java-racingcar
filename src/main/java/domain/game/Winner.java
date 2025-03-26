package domain.game;

import domain.car.Car;
import domain.car.Cars;

import java.util.ArrayList;

public class Winner{
    // 결과를 판단한다(우승자를 판단한다)

    private final ArrayList<Car> winner;

    public Winner(Cars cars){
        winner = judge(cars);
    }

    private ArrayList<Car> judge(Cars cars){
        return cars.getWinner();
    }


    public ArrayList<String> getCarNames() {
        ArrayList<String> carNames = new ArrayList<>();

        for (Car car : winner) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
