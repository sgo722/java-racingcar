package domain.game;

import domain.car.Car;
import domain.car.Cars;
import domain.car.MoveCount;
import domain.car.Name;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;

public class CarGameManager {
    // 게임을 운영한다.

    private final InputView inputView;
    private final OutputView outputView;
    private final Result result;

    public CarGameManager(InputView inputView, OutputView outputView, Result result) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.result = result;
    }

    public void run(){
        outputView.printInputCarName();
        ArrayList<String> carNames = inputView.parseCarName();

        Cars cars = new Cars(createCars(carNames));

        outputView.printInputPlayTime();
        int playTime = inputView.parsePlaytime();

        for(int t=0; t<playTime; t++){
            cars = new Cars(cars.play());

            HashMap<String, Integer> nameToCount = cars.getNameToCount();
            outputView.printCarStatus(nameToCount);
        }

        result.judge(cars);
        outputView.printResult(result.getCarNames());
    }

    private ArrayList<Car> createCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();

        for(String carName : carNames){
            cars.add(new Car(new Name(carName), new MoveCount()));
        }
        return cars;
    }
}