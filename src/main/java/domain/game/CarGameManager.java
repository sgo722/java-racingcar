package domain.game;

import domain.car.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;

public class CarGameManager {
    // 게임을 운영한다.
    private final InputView inputView;
    private final OutputView outputView;

    public CarGameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        Cars cars = setUpCars();
        int playTime = setUpPlayTime();

        for(int t=0; t<playTime; t++){
            cars = new Cars(cars.play());
            printResult(cars);
        }

        printWinner(cars);
    }

    private Cars setUpCars() {
        outputView.printInputCarName();
        ArrayList<String> carNames = inputView.parseCarName();

        Cars cars = new CarsFactory().createCars(carNames);

        return cars;
    }

    private int setUpPlayTime() {
        outputView.printInputPlayTime();
        int playTime = inputView.parsePlaytime();

        return playTime;
    }

    private void printResult(Cars cars) {
        HashMap<String, Integer> nameToCount = cars.getNameToCount();
        outputView.printCarStatus(nameToCount);
    }


    private void printWinner(Cars cars) {
        outputView.printWinner(cars.getWinner());
    }
}
