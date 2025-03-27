package domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoveStrategyTest {

    @DisplayName("랜덤값이 4이면 true를 반환한다")
    @Test
    void 랜덤값이_4면_true를_반환한다(){
        //given
        RandomNumberGenerator numberGenerator = new FixedNumberGenerator(4);
        MoveStrategy moveStrategy = new MoveStrategy(numberGenerator);

        //when
        boolean canMove = moveStrategy.canMove();

        //then
        Assertions.assertThat(canMove).isTrue();
    }

    @DisplayName("랜덤값이_4이상이면 true를 반환한다")
    @Test
    void 랜덤값이_4이상이면_true를_반환한다(){
        //given
        RandomNumberGenerator numberGenerator = new FixedNumberGenerator(5);
        MoveStrategy moveStrategy = new MoveStrategy(numberGenerator);

        //when
        boolean canMove = moveStrategy.canMove();

        //then
        Assertions.assertThat(canMove).isTrue();
    }

    @DisplayName("랜덤값이 4미만이면 false를 반환한다")
    @Test
    void 랜덤값이_4미만이면_false를_반환한다(){
        //given
        RandomNumberGenerator numberGenerator = new FixedNumberGenerator(3);
        MoveStrategy moveStrategy = new MoveStrategy(numberGenerator);

        //when
        boolean canMove = moveStrategy.canMove();

        //then
        Assertions.assertThat(canMove).isFalse();
    }

    @DisplayName("숫자에 따라 움직일 수 있는지 판단한다")
    @ParameterizedTest
    @CsvSource({
            "0,false",
            "3,false",
            "4,true",
            "9,true"
    })
    void 숫자에_따라_움직일_수_있는지_판단한다(int input, boolean expected) {
        // given
        MoveStrategy moveStrategy = new MoveStrategy(new FixedNumberGenerator(input));

        // when
        boolean result = moveStrategy.canMove();

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private class FixedNumberGenerator extends RandomNumberGenerator{

        private final int number;

        public FixedNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int getNumber(){
            return number;
        }
    }
}