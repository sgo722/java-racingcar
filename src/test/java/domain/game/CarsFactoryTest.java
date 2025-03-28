package domain.game;

import domain.car.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsFactoryTest {

    @DisplayName("자동차 이름 리스트만큼 Car 객체가 생성된다")
    @Test
    void 자동차_이름_개수만큼_Car가_생성된다() {
        CarsFactory factory = new CarsFactory();
        ArrayList<String> carNames = new ArrayList<>(List.of("yang", "jun", "yeong"));

        Cars cars = factory.createCars(carNames);

        Assertions.assertThat(cars.getNameToCount()).hasSize(3);
    }

    @DisplayName("자동차_목록이_비어있으면_에러가_발생한다")
    @Test
    void 자동차_목록이_비어있으면_에러가_발생한다() {
        CarsFactory factory = new CarsFactory();
        ArrayList<String> carNames = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> {
            factory.createCars(carNames);
        });
    }

    @DisplayName("자동차_목록이_null이면_에러가_발생한다")
    @Test
    void 자동차_목록이_null이면_에러가_발생한다() {
        CarsFactory factory = new CarsFactory();
        ArrayList<String> names = null;

        assertThrows(IllegalArgumentException.class, () -> {
            factory.createCars(names);
        });
    }
}