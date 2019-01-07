package Demo.Test.threadPool.callable;

import java.util.concurrent.Callable;

/**
 * Created by fx on 2018/12/6.
 */
public class MyCallable implements Callable<Integer>{
    private int x= 0;
    private int y = 0;
    public MyCallable(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Integer call() throws Exception {
        return x+y;
    }
}
