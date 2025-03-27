package domain.car;

public class FixedNumberGenerator extends RandomNumberGenerator{

    private final int number;

    public FixedNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int getNumber(){
        return number;
    }
}
