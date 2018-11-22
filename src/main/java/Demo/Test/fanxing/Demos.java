package Demo.Test.fanxing;

/**
 * Created by fx on 2018/8/9.
 */
public class Demos<T extends Number> {
    public <T> void printMsg(T ...args){
        for (T t:args){
            System.out.println(t);
        }
    }

    public   Demos(T key){
            this.key =key;
    }

    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }


    //加入上下界的泛型
    public <T extends  Number> T getName(Demos<T> demos){

        System.out.println(demos.getKey());
        T test = demos.getKey();
        return  test;
    }

}
