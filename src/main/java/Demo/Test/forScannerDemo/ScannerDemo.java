package Demo.Test.forScannerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by fx on 2018/2/24.
 */
public class ScannerDemo {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str;

        System.out.println("input end quit");

        do {
            str = bufferedReader.readLine();
            System.out.println(str);
        }while (!str.equals("end"));
    }
}
