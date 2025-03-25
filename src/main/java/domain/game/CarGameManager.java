package domain.game;

import domain.car.Car;
import domain.car.Name;
import domain.view.InputMessage;
import domain.view.OutputMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class CarGameManager {
    // 게임을 운영한다.

    private final InputMessage inputMessage;
    private final OutputMessage outputMessage;

    public CarGameManager(InputMessage inputMessage, OutputMessage outputMessage) {
        this.inputMessage = inputMessage;
        this.outputMessage = outputMessage;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        outputMessage.printInputCarName();
        ArrayList<String> carNames = inputMessage.parseCarName();


        ArrayList<Car> cars = createCars(carNames);

        outputMessage.printInputPlayTime();
        int playTime = inputMessage.parsePlaytime();

        CarGameService carGameService = new CarGameService(cars);

        for(int t=0; t<playTime; t++){
            carGameService.play();

            System.out.println("실행 결과");
            for(Car car: cars){
                car.printCarStatus();
            }
            System.out.println();
        }

        Winner winner = new Winner();
        winner.judge(cars);
        winner.printWinners();
    }

    private ArrayList<Car> createCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(new Name(carName)));
        }
        return cars;
    }
}
