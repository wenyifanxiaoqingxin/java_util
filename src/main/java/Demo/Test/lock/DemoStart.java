package Demo.Test.lock;

/**
 * @description:
 * @author: fanxiao
 * @date: 2019/11/5 15:55
 */
public class DemoStart {
    public static void main(String[] args) {

        final Counter counter = new Counter();


        new Thread(new Runnable() {
            public void run() {
                while (counter.getCount()>=0){
                    counter.desc1();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (counter.getCount()>=0){
                    counter.desc2();
                }
            }
        }).start();
    }
}
