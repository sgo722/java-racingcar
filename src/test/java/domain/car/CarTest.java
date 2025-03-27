package domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CarTest {

    @DisplayName("랜덤값이_4이상이면_움직이지_않는다")
    @Test
    void 랜덤값이_4이상이면_움직이지_않는다(){
        //given
        RandomNumberGenerator MoveNumberGenerator = new FixedNumberGenerator(4);
        MoveStrategy alwaysMoveStrategy = new MoveStrategy(MoveNumberGenerator);
        MoveCount moveCount = new MoveCount(0,alwaysMoveStrategy);
        String inputName = "양준영";
        Name name = new Name(inputName);
        Car car = new Car(name, moveCount);
        //when
        Car movedCar = car.move();

        //then
        Assertions.assertThat(movedCar.getName()).isEqualTo(inputName);
        Assertions.assertThat(movedCar.getMoveCount()).isEqualTo(moveCount.getMoveCount() + 1);
    }

    @DisplayName("랜덤값이_4미만이면_움직이지_않는다")
    @Test
    void 랜덤값이_4미만이면_움직이지_않는다(){
        //given
        RandomNumberGenerator StopNumberGenerator = new FixedNumberGenerator(2);
        MoveStrategy alwaysStopStrategy = new MoveStrategy(StopNumberGenerator);
        MoveCount moveCount = new MoveCount(0,alwaysStopStrategy);
        String inputName = "양준영";
        Name name = new Name(inputName);
        Car car = new Car(name, moveCount);
        //when
        Car movedCar = car.move();

        //then
        Assertions.assertThat(movedCar.getName()).isEqualTo(inputName);
        Assertions.assertThat(movedCar.getMoveCount()).isEqualTo(moveCount.getMoveCount());
    }

}