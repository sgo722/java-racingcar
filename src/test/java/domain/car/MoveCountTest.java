package domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCountTest {

    @DisplayName("움직이면_위치를_1만큼_증가시킨다")
    @Test
    void 움직이면_위치를_1만큼_증가시킨다(){
        //given
        MoveStrategy alwaysMoveStrategy = new FakeMoveStrategy(true);
        MoveCount moveCount = new MoveCount(0, alwaysMoveStrategy);
        //when
        MoveCount moved = moveCount.move();

        //then
        Assertions.assertThat(moved.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("움직이지_못하면_위치는_변하지않는다")
    @Test
    void 움직이지_못하면_위치는_변하지않는다(){
        //given
        MoveStrategy alwaysMoveStrategy = new FakeMoveStrategy(false);
        MoveCount moveCount = new MoveCount(0, alwaysMoveStrategy);
        //when
        MoveCount moved = moveCount.move();

        //then
        Assertions.assertThat(moved.getMoveCount()).isEqualTo(0);
    }

    private static class FakeMoveStrategy extends MoveStrategy{
        private final boolean movable;

        public FakeMoveStrategy(boolean movable){
            this.movable = movable;
        }

        @Override
        public boolean canMove() {
            return movable;
        }
    }
}