package domain.view;


import java.util.ArrayList;

public class OutputView {
    // 메세지를 출력한다.

    public void printInputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputPlayTime(){
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public void printResult(ArrayList<String> carNames){
        for(int i=0; i<carNames.size(); i++){
            System.out.print("최종 우승자 : ");
            if(i == carNames.size()-1){
                System.out.println(carNames);
            }
            if(i != carNames.size()-1){
                System.out.println(carNames + " ,");
            }
        }
    }
}
