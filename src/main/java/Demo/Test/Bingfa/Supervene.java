package Demo.Test.Bingfa;

/**
 * Created by fx on 2018/2/5.
 */
public class Supervene implements Runnable{

    private int ticket = 10;
    public void run() {
        while(true){
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出票！请稍等...");
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张火车票，还剩余" + ticket + "张！");

                } else {
                    System.out.println("票已售完！");

                    try {
                        Thread.sleep(1000 * 60 * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
