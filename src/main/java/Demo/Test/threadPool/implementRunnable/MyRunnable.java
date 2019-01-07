package Demo.Test.threadPool.implementRunnable;

/**
 * Created by fx on 2018/12/6.
 */
public class MyRunnable implements Runnable{

    public void run() {
        System.out.println("我要教练");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("他来了"+Thread.currentThread().getName());
        System.out.println("教我游泳，然后他走了");
    }

}
