package domain.game;

import domain.car.Car;
import domain.car.Name;
import util.OutputMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class CarGameManager {
    // 게임을 운영한다.

    public void run(){
        Scanner sc = new Scanner(System.in);

        OutputMessage.printInputCarName();
        ArrayList<String> carNames = parseCarName(sc);

        OutputMessage.printInputPlayTime();
        int playTime = parsePlaytime(sc);

        ArrayList<Car> cars = createCars(carNames);

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

    private int parsePlaytime(Scanner sc) {
        String input = sc.next();
        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException("올바른 숫자를 입력해주세요");
    }

    private ArrayList<Car> createCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(new Name(carName)));
        }
        return cars;
    }

    private ArrayList<String> parseCarName(Scanner sc) {
        String input = sc.nextLine();


        ArrayList<String> carNames = new ArrayList<>();

        String[] tokens = input.split(",");
        for(String carName : tokens) {
            carNames.add(carName);
        }

        return carNames;
    }
}
