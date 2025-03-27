package domain.car;

import static util.ErrorCode.*;

public class Name {
    // 이름에 대한 속성과 기능을 가진다.
    private final int NAME_MAX_LENGTH = 5;
    private final int NAME_MIN_LENGTH = 1;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateIsNotEmpty(name);
        validateIsNotNull(name);
    }

    private void validateLength(String name){
        if(name.length() < NAME_MIN_LENGTH || name.length() >  NAME_MAX_LENGTH){
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    private void validateIsNotEmpty(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException(NAME_IS_NOT_EMPTY);
        }
    }

    private void validateIsNotNull(String name){
        if(name == null){
            throw new IllegalArgumentException(NAME_IS_NOT_NULL);
        }
    }
    public String getName() {
        return name;
    }
}
