package Demo.Test.ConsumerAndProductTwo;

/**
 * Created by fx on 2019/1/15.
 */
public class ConsumerFactory extends Thread {

    private int number;
    private StoreInterface  storeHouse;

    public ConsumerFactory(int number,StoreInterface storeHouse){
        this.number =number;
        this.storeHouse = storeHouse;
    }

    public void  consume(int number){
        storeHouse.consume(number);
    }

    @Override
    public void run() {
        consume(number);
    }
}
