import domain.game.CarGameManager;
import domain.game.Winner;
import domain.view.InputView;
import domain.view.OutputView;

public class CarGameApplication {
    public static void main(String[] args) {

        CarGameManager carGameManager = new CarGameManager(new InputView(), new OutputView(), new Winner());
        carGameManager.run();
    }
}
