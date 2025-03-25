package domain.car;

import java.util.ArrayList;
import java.util.HashMap;

public class Cars {
    // 자동차 일급 컬렉션
    // 자동차들을 가진다.
    // 자동차 게임을 진행한다.

    private final ArrayList<Car> cars = new ArrayList<>();

    public Cars(ArrayList<String> carNames){
        createCars(carNames);
    }

    public void play(){
        cars.forEach(Car::move);
    }


    public ArrayList<Car> getCars(){
        return cars;
    }

    public HashMap<String, Integer> getNameToCount(){
        HashMap<String, Integer> nameToCount = new HashMap<>();
        for (Car car : cars) {
            nameToCount.put(car.getName(), car.getMoveCount());
        }
        return nameToCount;
    }

    private void createCars(ArrayList<String> carNames) {
        for(String carName : carNames){
            cars.add(new Car(new Name(carName)));
        }
    }
}
