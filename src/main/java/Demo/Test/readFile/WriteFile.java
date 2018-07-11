package Demo.Test.readFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by fx on 2018/4/12.
 */
public class WriteFile {


    public static void main(String[] args) {
        File file = new File("/Users/crionline/Desktop/cache_feature.txt");
        try {
            if(!file.exists()){

                file.createNewFile();

            }
            String s = "11111\n";
            FileOutputStream outputStream = new FileOutputStream(file,true);
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
