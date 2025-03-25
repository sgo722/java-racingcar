package domain.game;

import domain.car.Car;

import java.util.ArrayList;

public class Winner {

    // 우승자를 결정한다.
    private ArrayList<Car> winners;

    public Winner() {
        winners = new ArrayList<>();
    }

    public void judge(ArrayList<Car> cars){
        int maxMoveCount = 0;
        for (Car car : cars) {
            int currentCarMoveCount = car.getMoveCount();
            if(maxMoveCount < currentCarMoveCount){
                winners = new ArrayList<>();
                winners.add(car);
                maxMoveCount = currentCarMoveCount;
            }else if(maxMoveCount == currentCarMoveCount){
                winners.add(car);
            }
        }
    }

    public void printWinners(){
        for(int i=0; i<winners.size(); i++){
            System.out.print("최종 우승자 : ");
            if(i == winners.size()-1){
                System.out.println(winners.get(i).getName());
            }else{
                System.out.println(winners.get(i).getName() + " ,");
            }
        }
    }
}
