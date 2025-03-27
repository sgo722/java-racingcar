package domain.game;

import domain.car.Car;
import domain.car.Cars;
import domain.car.Name;

import java.util.ArrayList;
import java.util.List;

import static util.ErrorCode.CARS_IS_EMPTY;
import static util.ErrorCode.CARS_IS_NULL;

public class CarsFactory {

    public Cars createCars(ArrayList<String> carNames) {
        validate(carNames);
        List<Car> cars = new ArrayList<>();

        for(String carName : carNames){
            cars.add(new Car(new Name(carName)));
        }

        return new Cars(cars);
    }

    private void validate(List<String> carNames){
        validateCarsIsNotNull(carNames);
        validateCarsIsEmpty(carNames);
    }

    private static void validateCarsIsNotNull(List<String> carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(CARS_IS_NULL);
        }
    }

    private static void validateCarsIsEmpty(List<String> carNames) {
        if(carNames.isEmpty()){
            throw new IllegalArgumentException(CARS_IS_EMPTY);
        }
    }
}
