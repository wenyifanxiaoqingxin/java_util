package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fx on 2018/9/10.
 * 锁申请等待时限
 */
public class TryLockTest implements Runnable{

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public void run() {

        try {
            if(reentrantLock.tryLock(2, TimeUnit.SECONDS)){
                Thread.sleep(1000);
            }else {
                System.out.println(Thread.currentThread().getName()+"获取失败");
            }
        } catch (InterruptedException e) {
            if(reentrantLock.isHeldByCurrentThread()) reentrantLock.unlock();

        }

    }

    public static void main(String[] args) {
        TryLockTest tryLockTest = new TryLockTest();
        Thread t1 = new Thread(tryLockTest); t1.setName("one");
        Thread t2 = new Thread(tryLockTest); t2.setName("two");

        t1.start();
        t2.start();
    }
}
