import domain.game.CarGameManager;
import domain.game.Winner;
import view.InputView;
import view.OutputView;

public class CarGameApplication {
    public static void main(String[] args) {

        CarGameManager carGameManager = new CarGameManager(new InputView(), new OutputView(), new Winner());
        carGameManager.run();
    }
}
