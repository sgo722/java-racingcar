package domain.car;

public class MoveCount {

    private int count;

    public MoveCount(int count) {
        this.count = count;
    }

    public void plusCount(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
