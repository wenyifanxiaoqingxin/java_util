package Demo.Test.readFile;


import javax.sound.midi.Soundbank;
import java.io.*;

public class readFiles {

        public static void  main(String[] args) throws IOException {

            StringBuffer stringBuffer = new StringBuffer("");
            FileReader fileReader = new FileReader("/Users/crionline/Desktop/pbookinfo.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("/Users/crionline/Desktop/pbookinfonew.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String str = null;
            int i= 0;
            while((str = bufferedReader.readLine())!=null){


                if(i==3||i==4){

                   String[] arr =  str.split("\\s+");

                   String price = arr[3];
                   if(i==3){
                       price = String.valueOf(Float.parseFloat(price)+20);
                   }
                   if(i==4){
                       price = String.valueOf(Float.parseFloat(price)+30);
                   }

                   //拼接字符串***
                    for(int j=0;j<arr.length;j++){

                       if(j==3){
                           stringBuffer.append(price+"\t");
                       }else{
                           stringBuffer.append(arr[j]+"\t");
                       }
                    }
                    str =null;
                    str = stringBuffer.toString();
                    stringBuffer=new StringBuffer("");
                }
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                System.out.println(str);
                i++;
            }

            bufferedReader.close();
            fileReader.close();

            bufferedWriter.close();
            fileWriter.close();

        }
}
