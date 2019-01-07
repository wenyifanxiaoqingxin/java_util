package Demo.Test.threadPool.implementRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyRunnable myRunnable = new MyRunnable();
        executorService.submit(myRunnable);

        executorService.submit(myRunnable);
        executorService.submit(myRunnable);

    }
}
