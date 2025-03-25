package domain.game;

import domain.car.Cars;

import java.util.ArrayList;


public interface Result {
    // 결과를 판단한다.
    // 결과를 출력한다.

    void judge(Cars cars);

    ArrayList<String> getCarNames();
}
