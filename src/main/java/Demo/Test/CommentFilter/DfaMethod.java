package Demo.Test.CommentFilter;

import java.io.*;
import java.util.*;

/**
 * Created by fx on 2018/3/14.
 */
public class DfaMethod {


     private static String path = "C:/Users/fanxiao/Desktop/1.txt";
    private static String enCoding = "gbk";

    public HashMap sensitiveWordMap;

    public Map initKeyMap()  {

        Set set = null;
        try {
            set = readSensitiveWordFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSensitiveWordToMap(set);

        return sensitiveWordMap ;
    }


    //读取文本的内容，放入set中。
    public Set<String> readSensitiveWordFile() throws Exception{

        Set<String> set = null;
        File file = new File(path);

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),enCoding);
        try {
        if(file.exists()&&file.isFile()){

            set = new HashSet<String>();

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String text = null;


                while((text=(bufferedReader.readLine()))!=null){

                    set.add(text);

                }
            }else{
                throw new Exception("文件查询不到");
            }

        }
        catch (IOException e) {
            e.printStackTrace();

        }finally {
            inputStreamReader.close();
        }
        return set;

    }


    //构建dfa算法，构建匹配敏感词的map
    public void addSensitiveWordToMap(Set<String> set){

        sensitiveWordMap = new HashMap(set.size(),1f);

        String key = null;

        Map nowMap = null;
        Map<String,String> temp = new HashMap<String, String>();

        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()){
            key = iterator.next();
            nowMap = sensitiveWordMap;
            for(int i=0,length = key.length();i<length;i++){

                char keyChar = key.charAt(i);
                Object objectMap = nowMap.get(keyChar);

                if(objectMap!=null){

                    nowMap = (Map) objectMap;
                }else{
                    temp = new HashMap<String, String>();
                    temp.put("isEnd","0");
                    nowMap.put(keyChar,temp);
                    nowMap = temp;
                }
                if(i == key.length()-1){
                    nowMap.put("isEnd","1");
                }
            }
        }

    }


}
