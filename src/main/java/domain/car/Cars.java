package domain.car;

import java.util.ArrayList;

public class Cars {

    private final ArrayList<Car> cars;

    public Cars(ArrayList<String> carNames){
        cars = createCars(carNames);
    }

    public void play(){
        cars.forEach(Car::move);
    }

    public void printResult(){

        System.out.println("실행 결과");
        for(Car car: cars){
            car.printCarStatus();
        }
        System.out.println();
    }

    private ArrayList<Car> createCars(ArrayList<String> carNames) {
        for(String carName : carNames){
            cars.add(new Car(new Name(carName)));
        }
        return cars;
    }
}
