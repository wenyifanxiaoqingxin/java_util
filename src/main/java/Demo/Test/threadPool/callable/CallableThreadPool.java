package Demo.Test.threadPool.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by fx on 2018/12/6.
 * 具有返回值的线程池
 */
public class CallableThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MyCallable myCallable = new MyCallable(100,20);
        MyCallable myCallable1 = new MyCallable(200,10);
        Future<Integer> result = executorService.submit(myCallable);
        Integer sum  = result.get();
        System.out.println("sum=" + sum);

        result = executorService.submit(myCallable1);

        sum+= result.get();

        System.out.println("sum=" + sum);
    }
}
