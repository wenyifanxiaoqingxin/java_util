package Demo.Test.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: the condition in use
 * @author: fanxiao
 * @date: 2019/11/5 15:47
 */
public class Counter {
    private int count = 100;
    private ReentrantLock lock = new ReentrantLock();
    Condition conditionOne = lock.newCondition();
    Condition conditionTwo = lock.newCondition();

    boolean state = true;

    public void desc1(){

        lock.lock();
        try {
            while (state){
                conditionOne.await();
            }
            if(count>=0){
                System.out.println(Thread.currentThread().getName()+"---->"+count);
                count--;
            }
            state = true;
            conditionTwo.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void desc2(){

        lock.lock();
        try {
            while (!state){
                conditionTwo.await();
            }
            if(count>=0){
                System.out.println(Thread.currentThread().getName()+"---->"+count);
                count--;
            }
            state = false;
            conditionOne.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
