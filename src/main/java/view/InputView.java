package view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {

    public ArrayList<String> parseCarName() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        ArrayList<String> carNames = new ArrayList<>();

        String[] tokens = input.split(",");
        for(String carName : tokens) {
            carNames.add(carName);
        }

        return carNames;
    }

    public int parsePlaytime() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException("올바른 숫자를 입력해주세요");
    }

}
