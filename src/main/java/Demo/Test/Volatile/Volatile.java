package Demo.Test.Volatile;

/**
 * Created by fx on 2018/7/19.
 */
public class Volatile {
    public volatile int inc = 0;
    public synchronized void increase(){
        inc++;
    }

    public static void main(String[] args){

        final Volatile test = new Volatile();
        for(int i=0;i<10;i++){

            new Thread(){
                public void run(){
                  for(int j=0;j<1000;j++){
                      test.increase();
                  }
                };
            }.start();
        }

        while(Thread.activeCount()>1)
            Thread.yield();

        System.out.println(test.inc);
    }
}
