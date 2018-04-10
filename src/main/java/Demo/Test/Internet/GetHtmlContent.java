package Demo.Test.Internet;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by fx on 2018/2/7.
 */
public class GetHtmlContent {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            URL url = new URL("http://192.168.200.51:8085/countuser");
             bufferedReader = new BufferedReader(new InputStreamReader((url.openStream())));
             bufferedWriter = new BufferedWriter(new FileWriter("/Users/crionline/Desktop/data.html"));
            String line ;
            while ((line = bufferedReader.readLine())!=null){
                System.out.println(line);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
