import java.util.ArrayList;

public class CarGameService {
    // 자동차 게임을 진행한다.

    private final ArrayList<Car> cars;

    public CarGameService() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car){
        this.cars.add(car);
    }

    public void play(){
        cars.forEach(Car::move);
    }

}
