package Demo.Test.Bingfa;

import Demo.Test.Volatile.Volatile;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by fx on 2018/9/18.
 */
public class ThreadPoolDemo {
    public  static  int numbers =10;
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,200, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<Runnable>(5));
            Supervene supervene = new Supervene(1,numbers);
            threadPoolExecutor.submit(supervene);
            System.out.println("线程池中线程数目："+threadPoolExecutor.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor.getQueue().size()+"，已执行玩别的任务数目："+threadPoolExecutor.getCompletedTaskCount());
        threadPoolExecutor.shutdown();
    }
}
