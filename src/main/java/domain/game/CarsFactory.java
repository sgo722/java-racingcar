package domain.game;

import domain.car.Car;
import domain.car.Cars;
import domain.car.MoveCount;
import domain.car.Name;

import java.util.ArrayList;

public class CarsFactory {

    public Cars createCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();

        for(String carName : carNames){
            cars.add(new Car(new Name(carName)));
        }
        return new Cars(cars);
    }

}
