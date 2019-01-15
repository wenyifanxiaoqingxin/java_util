package Demo.Test.ConsumerAndProductTwo;

/**
 * Created by fx on 2019/1/15.
 */
public class ProductFactory extends Thread{

    private int number;
    private StoreInterface storeHouse;

    public ProductFactory(int number,StoreInterface storeHouse){
        this.number = number;
        this.storeHouse = storeHouse;
    }

    @Override
    public void run() {
        produce(number);
    }

    public void produce(int number){
        storeHouse.produce(number);
    }
}
