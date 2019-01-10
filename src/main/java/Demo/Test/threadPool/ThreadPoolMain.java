package Demo.Test.threadPool;

import Demo.Test.threadPool.callable.MyCallable;
import Demo.Test.threadPool.implementRunnable.MyRunnable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by fx on 2019/1/10.
 */
public class ThreadPoolMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //线程池的使用（无结果返回）  new Runnable也可以自己实现此接口来传递到这里
        //第一种：
        ThreadPoolExecutorUtil.threadPool.submit(new Runnable() {
            public void run() {
                //线程要执行的东西
                System.out.println("(第一种方法)just a demo to do something");
            }
        });
        System.out.println("**********隔离线**********");
        //第二种：
        ThreadPoolExecutorUtil.threadPool.submit(new MyRunnable());
        System.out.println("**********隔离线**********");
        //线程池的使用（有结果）  new Runnable也可以自己实现此接口来传递到这里
        //第一种：
        Future<Integer> futureOne = ThreadPoolExecutorUtil.threadPool.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return 1+1;
            }
        });
        System.out.println("(第一种方法)有返回结果的异步任务:"+futureOne.get());
        System.out.println("**********隔离线**********");
        //第二种：
        Future<Integer> futureTwo = ThreadPoolExecutorUtil.threadPool.submit(new MyCallable(1,1));
        System.out.println("(第二种方法)有返回结果的异步任务:"+futureTwo.get());

        //定时线程池的使用  new Runnable也可以自己实现此接口来传递到这里
        //第一种：
        ThreadPoolExecutorUtil.scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                //线程要执行的东西
                System.out.println("just a scheduled tase to do");
            }
        },1,2, TimeUnit.SECONDS);
        System.out.println("**********隔离线**********");

    }
}
