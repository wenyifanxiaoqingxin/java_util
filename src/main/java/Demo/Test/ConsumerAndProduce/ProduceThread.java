package Demo.Test.ConsumerAndProduce;

/**
 * Created by fx on 2018/2/8.
 */
public class ProduceThread extends Thread{


    private Restory restory;
    private int number;

    public ProduceThread(Restory restorys,int numbers){
        restory = restorys;
        number =numbers;

    }
    @Override
    public void run() {

        for(int i =0;i<10;i++){

            restory.put(i);
            System.out.println("生产者 #"+this.number+" put "+i);

            try {
                sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
