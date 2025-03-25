package domain.car;

public class Count {

    private int count;

    public Count(int count) {
        this.count = count;
    }

    public void plusCount(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
