package Demo.Test.threadPool;

import java.util.concurrent.*;

/**
 * Created by fx on 2018/12/6.
 */
public class ThreadPoolExecutorUtil {

    /**
     * 创建一个线程池(完整入参说明):
     * corePoolSize:核心线程数为5,
     * maximumPoolSize:最大线程数为10 (maximumPoolSize),
     * keepAliveTime:存活时间为60分钟(keepAliveTime),
     * TimeUnit:存活时间单位（MINUTES，分）
     * workQueue：工作队列为LinkedBlockingQueue,ArrayBlockingQueue,SynchronousQueue,PriorityBlockingQueue,DelayedWorkQueue
     * threadFactory：线程工厂为DefaultThreadFactory,PrivilegedThreadFactory,自定义线程工厂
     * 饱和策略(拒绝策略)为AbortPolicy: 抛出异常(handler).
     */
    public static ExecutorService threadPool = new ThreadPoolExecutor(5,10,2,
            TimeUnit.MINUTES,new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

    //只有一个线程的线程池 没有超时时间, 工作队列使用无界的LinkedBlockingQueue
    public static ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

    //大小不限的线程池 核心线程数为0, 最大线程数为Integer.MAX_VALUE, 存活时间为60秒 该线程池可以无限扩展,并且当需求降低时会自动收缩, 工作队列使用同步移交SynchronousQueue.
    public static ExecutorService cacheThreadPool = Executors.newCachedThreadPool();

    //有固定线程的线程池(即corePoolSize = maximumPoolSize) 没有超时时间,工作队列使用无界的LinkedBlockingQueue
    public static ExecutorService fixThreadPool = Executors.newFixedThreadPool(5);

    //给定的延迟之后运行任务, 或者定期执行任务的线程池
    public static ScheduledExecutorService scheduledThreadPool =Executors.newScheduledThreadPool(5);




}
