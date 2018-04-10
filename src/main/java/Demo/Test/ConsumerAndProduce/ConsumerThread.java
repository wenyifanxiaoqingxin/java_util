package Demo.Test.ConsumerAndProduce;

/**
 * Created by fx on 2018/2/8.
 */
public class ConsumerThread extends Thread{

    private Restory restory;
    private int number;


    public ConsumerThread(Restory restorys,int numbers){

        restory = restorys;
        number = numbers;
    }

    @Override
    public void run() {
        int value = 0;
        for(int i = 0;i<10;i++){


            value = restory.get();
            System.out.println("消费者 #"+this.number+" get "+value);
        }
    }
}
