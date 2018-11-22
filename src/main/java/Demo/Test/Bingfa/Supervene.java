package Demo.Test.Bingfa;

/**
 * Created by fx on 2018/2/5.
 */
public class Supervene implements Runnable{

    private int taskNumber;
    private int tickets;

    public  Supervene(int taskNumber,int tickets){
        this.taskNumber = taskNumber;
        this.tickets = tickets;
    }
    public void run() {
        while(true){
            synchronized (Supervene.class) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出票！请稍等...");
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张火车票，还剩余" + tickets + "张！");

                } else {
                    System.out.println("票已售完！");
                    try {
                        Thread.currentThread().sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
