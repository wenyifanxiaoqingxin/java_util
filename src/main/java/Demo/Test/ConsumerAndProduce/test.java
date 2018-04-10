package Demo.Test.ConsumerAndProduce;

/**
 * Created by fx on 2018/2/8.
 */
public class test {


    public static void main(String[] args) {

        Restory restory = new Restory();

        ProduceThread produceThread = new ProduceThread(restory,1);
        ConsumerThread consumerThread = new ConsumerThread(restory,1);

        produceThread.start();
        consumerThread.start();
    }
}
