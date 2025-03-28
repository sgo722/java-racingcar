package view;

import java.util.ArrayList;
import java.util.Scanner;

import static util.ErrorCode.INPUT_IS_NOT_NUMBER;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();
    private final Scanner sc = new Scanner(System.in);

    public ArrayList<String> parseCarName() {
        String input = sc.nextLine();
        validateCarNames(input);

        return parseCarName(input);
    }

    private void validateCarNames(String input) {
        inputValidator.validateIsEmpty(input);
    }

    private ArrayList<String> parseCarName(String input) {
        ArrayList<String> carNames = new ArrayList<>();

        String[] tokens = input.split(",");

        for(String carName : tokens) {
            carNames.add(carName);
        }
        return carNames;
    }

    public int parsePlaytime() {
        String input = sc.next();

        validatePlayTime(input);
        return parseInt(input);
    }

    private void validatePlayTime(String input) {
        inputValidator.validateIsEmpty(input);
        inputValidator.validatePositiveNumber(input);
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

}
