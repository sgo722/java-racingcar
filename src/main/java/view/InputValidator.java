package view;

import static util.ErrorCode.INPUT_IS_NOT_EMPTY;
import static util.ErrorCode.INPUT_NUMBER_IS_NOT_POSITIVE;

public class InputValidator {

    public void validatePositiveNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_NUMBER_IS_NOT_POSITIVE);
        }
    }

    public void validateIsEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException(INPUT_IS_NOT_EMPTY);
        }
    }
}
