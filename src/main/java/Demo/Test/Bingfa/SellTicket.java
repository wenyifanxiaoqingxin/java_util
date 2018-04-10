package Demo.Test.Bingfa;

/**
 * Created by fx on 2018/2/5.
 */
public class SellTicket {
    public static void  main(String[] args){

        Supervene supervene = new Supervene();

        Thread t1 = new Thread(supervene,"one window");
        Thread t2 = new Thread(supervene,"two window");
        Thread t3 = new Thread(supervene,"three window");

        t1.start();
        t2.start();
        t3.start();


        String s = "q11";
    }
}
