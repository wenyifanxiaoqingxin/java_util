package Demo.Test;

/**
 * Created by fx on 2018/11/12.
 */
public class Louti {

    public static void main(String[] args) {

        System.out.println(getResultByDP(1));
    }

    public static  int getResultByDP(int n){

        if (n <1) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }

        int a = 1;
        int b = 2;
        int temp = 0;

        for (int i = 3; i < n+1 ; i++) {
            temp = a + b;
            a = b;
            b= temp;
        }

        return temp;

    }
}
