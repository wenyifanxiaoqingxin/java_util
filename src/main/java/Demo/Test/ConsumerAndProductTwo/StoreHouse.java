package Demo.Test.ConsumerAndProductTwo;


import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fx on 2019/1/15.
 */
public class StoreHouse implements StoreInterface{

    private LinkedList linkList = new LinkedList();

    private static int Max_Value = 100;
    private int number;
    private ReentrantLock reentrantLock = new ReentrantLock();


    public void produce(int number){
        synchronized (linkList){
            while(linkList.size()+number>Max_Value){
                System.out.println("【要生产的产品数量】:" + number + "\t【库存量】:"+ linkList.size() + "\t暂时不能执行生产任务!");
                try {
                    linkList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i=0;i<number;i++ ){
                linkList.add(new Object());
        }

        System.out.println("【已经生产产品数】:" + number + "\t【现仓储量为】:" + linkList.size());

        linkList.notifyAll();

    }

    public void consume(int number){

        synchronized (linkList){
            while (linkList.size()<number){
                System.out.println("【要消费的产品数量】:" + number + "\t【库存量】:"+ linkList.size() + "\t暂时不能执行消费任务!");
                try {
                    linkList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        for (int i=0;i<number;i++ ){
            linkList.remove();
        }

        System.out.println("【已经消费产品数】:" + number + "\t【现仓储量为】:" + linkList.size());

        linkList.notifyAll();
    }

}
