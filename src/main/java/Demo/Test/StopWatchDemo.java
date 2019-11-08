package Demo.Test;


import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/11/6 11:05
 */
public class StopWatchDemo {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("耗时执行");

        stopWatch.start("第一个任务开始");
        TimeUnit.SECONDS.sleep(3);
        stopWatch.stop();

        stopWatch.start("第二个任务开始");
        TimeUnit.SECONDS.sleep(2);
        stopWatch.stop();

        stopWatch.start("第三个任务开始");
        TimeUnit.SECONDS.sleep(4);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }

}
