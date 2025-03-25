package domain.game;

import domain.car.Cars;
import domain.view.InputView;
import domain.view.OutputView;

import java.util.ArrayList;

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

        Cars cars = new Cars(carNames);

        outputView.printInputPlayTime();
        int playTime = inputView.parsePlaytime();


        for(int t=0; t<playTime; t++){
            cars.play();
            cars.printResult();
        }

        result.judge(cars);
        outputView.printResult(result.getCarNames());
    }
}
