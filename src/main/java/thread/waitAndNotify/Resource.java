package thread.waitAndNotify;

/**
 * Created by fx on 2018/12/6.
 */
public class Resource {
    private String name;
    private String sex;
    private boolean flag;

    public synchronized void set(String name,String sex){
        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }
}
