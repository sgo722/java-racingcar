package domain.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static util.ErrorCode.*;

public class Cars {
    // 자동차 일급 컬렉션
    // 자동차들을 가진다.
    // 자동차 게임을 진행한다.
    private final List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public ArrayList<Car> play(){
        ArrayList<Car> playedCars = new ArrayList<>();
        for(Car car : cars) {
            playedCars.add(car.move());
        }

        return playedCars;
    }

    public List<String> getWinner(){
        int maxMoveCount = 0;
        ArrayList<String> winners = new ArrayList<>();

        for (Car car : cars) {
            int currentCarMoveCount = car.getMoveCount();
            if(maxMoveCount < currentCarMoveCount){
                winners = new ArrayList<>();
                winners.add(car.getName());
                maxMoveCount = currentCarMoveCount;
            }else if(maxMoveCount == currentCarMoveCount){
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public Map<String, Integer> getNameToCount(){
        Map<String, Integer> nameToCount = new HashMap<>();
        for (Car car : cars) {
            nameToCount.put(car.getName(), car.getMoveCount());
        }

        return nameToCount;
    }
}
