package view;


import java.util.ArrayList;
import java.util.HashMap;

public class OutputView {
    // 메세지를 출력한다.

    public void printInputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputPlayTime(){
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public void printResult(ArrayList<String> carNames){
        int lastIdx = carNames.size()-1;

        for(int i=0; i<carNames.size(); i++){
            System.out.print("최종 우승자 : ");
            if(i == lastIdx){
                System.out.println(carNames);
            }
            if(i != lastIdx){
                System.out.println(carNames + " ,");
            }
        }
    }

    public void printCarStatus(HashMap<String, Integer> nameToMoveCount){
        System.out.println("실행 결과");
        for(String carName : nameToMoveCount.keySet()){
            System.out.print(carName + " : ");
            for(int i = 0; i < nameToMoveCount.get(carName); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
