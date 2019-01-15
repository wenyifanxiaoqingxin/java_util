package Demo.Test.ConsumerAndProductTwo;

import Demo.Test.threadPool.ThreadPoolExecutorUtil;

/**
 * Created by fx on 2019/1/15.
 */
public class MainDemo {

    public static void main(String[] args) {
        StoreHouse storeHouse = new StoreHouse();
        for(int i =0;i<10;i++){
            ThreadPoolExecutorUtil.threadPool.submit(new ConsumerFactory(5,storeHouse));
            ThreadPoolExecutorUtil.threadPool.submit(new ProductFactory(3,storeHouse));

        }

        System.out.println("**************分割线****************");
        ReentrantlockStore reentrantlockStore = new ReentrantlockStore();
        for(int i =0;i<10;i++){
            ThreadPoolExecutorUtil.threadPool.submit(new ConsumerFactory(5,reentrantlockStore));
            ThreadPoolExecutorUtil.threadPool.submit(new ProductFactory(3,reentrantlockStore));
        }


    }
}
