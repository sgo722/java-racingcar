package domain.game;

import domain.car.Car;
import domain.car.Cars;
import domain.car.Name;
import domain.view.InputView;
import domain.view.OutputView;

import java.util.ArrayList;

public class CarGameManager {
    // 게임을 운영한다.

    private final InputView inputView;
    private final OutputView outputView;

    public CarGameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        outputView.printInputCarName();
        ArrayList<String> carNames = inputView.parseCarName();

        Cars cars = new Cars(carNames);


        outputView.printInputPlayTime();
        int playTime = inputView.parsePlaytime();


        for(int t=0; t<playTime; t++){
            cars.play();
            cars.printResult();
        }

//        Winner winner = new Winner();
//        winner.judge(cars);
//        winner.printWinners();
    }
}
