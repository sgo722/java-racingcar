package domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.tuple;

class CarsTest {


    @DisplayName("자동차는_전진조건_불만족시_정지한다")
    @Test
    void 자동차는_전진조건_불만족시_정지한다() {
        // given
        Car stopCar = new Car(new Name("정지"), new MoveCount(0, new MoveStrategy(new FixedNumberGenerator(1))));
        Cars cars = new Cars(List.of(stopCar));
        // when
        ArrayList<Car> playedCars = cars.play();

        // then
        Assertions.assertThat(playedCars.size()).isEqualTo(1);
        Assertions.assertThat(playedCars.get(0).getMoveCount()).isEqualTo(0);
    }

    @DisplayName("자동차는 전진 조건을 만족하면 전진한다")
    @Test
    void 자동차는_전진조건_만족시_전진한다() {
        // given
        Car moveCar = new Car(new Name("전진"), new MoveCount(0, new MoveStrategy(new FixedNumberGenerator(4))));
        Cars cars = new Cars(List.of(moveCar));
        // when
        ArrayList<Car> playedCars = cars.play();

        // then
        Assertions.assertThat(playedCars.size()).isEqualTo(1);
        Assertions.assertThat(playedCars.get(0).getMoveCount()).isEqualTo(1);
    }

    @DisplayName("Cars는_자동차들을_전진시킨다")
    @Test
    void Cars는_자동차들을_전진시킨다() {
        // given
        Car stopCar = new Car(new Name("멈춤"), new MoveCount(0, new MoveStrategy(new FixedNumberGenerator(1))));
        Car moveCar = new Car(new Name("전진"), new MoveCount(0, new MoveStrategy(new FixedNumberGenerator(4))));
        Cars cars = new Cars(List.of(stopCar, moveCar));

        // when
        List<Car> playedCars = cars.play();

        // then
        Assertions.assertThat(playedCars)
            .extracting(Car::getName, Car::getMoveCount)
            .containsExactly(
                    tuple("멈춤", 0),
                    tuple("전진", 1)
            );
    }

    @DisplayName("우승자가_한명인_경우_확인한다")
    @Test
    void 우승자가_한명인_경우_확인한다() {
        // given
        Car firstCar = new Car(new Name("yang"), new MoveCount(3));
        Car secondCar = new Car(new Name("jun"), new MoveCount(2));
        Car thridCar = new Car(new Name("yeong"), new MoveCount(0));
        Cars cars = new Cars(List.of(firstCar, secondCar, thridCar));

        // when
        List<String> winner = cars.getWinner();

        // then
        Assertions.assertThat(winner.size()).isEqualTo(1);
        Assertions.assertThat(winner)
                .containsExactly("yang");
    }

    @DisplayName("우승자가_한명인_이상인_경우_확인한다")
    @Test
    void 우승자가_한명인_이상인_경우_확인한다() {
        // given
        Car firstCar = new Car(new Name("yang"), new MoveCount(3));
        Car secondCar = new Car(new Name("jun"), new MoveCount(3));
        Car thridCar = new Car(new Name("yeong"), new MoveCount(0));
        Cars cars = new Cars(List.of(firstCar, secondCar, thridCar));

        // when
        List<String> winner = cars.getWinner();

        // then
        Assertions.assertThat(winner.size()).isEqualTo(2);
        Assertions.assertThat(winner)
                .containsExactlyInAnyOrder("yang","jun");
    }

    @DisplayName("자동차들의_이름과_이동거리를_Map으로_반환한다")
    @Test
    void 자동차들의_이름과_이동거리를_Map으로_반환한다() {
        // given
        Car firstCar = new Car(new Name("yang"), new MoveCount(3));
        Car secondCar = new Car(new Name("jun"), new MoveCount(2));
        Car thridCar = new Car(new Name("yeong"), new MoveCount(0));
        Cars cars = new Cars(List.of(firstCar, secondCar, thridCar));

        // when
        Map<String, Integer> nameToCount = cars.getNameToCount();

        // then
        Assertions.assertThat(nameToCount)
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        "yang", 3,
                        "jun", 2,
                        "yeong", 0
                ));
    }
}