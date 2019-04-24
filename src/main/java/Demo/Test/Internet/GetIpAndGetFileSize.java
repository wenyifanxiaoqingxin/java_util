//package Demo.Test.Internet;
//
//import apple.laf.JRSUIConstants;
//import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_zh_CN;
//
//import java.io.IOException;
//import java.net.Inet4Address;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
///**
// * Created by fx on 2018/2/7.
// */
//public class GetIpAndGetFileSize {
//
//    public static void main(String[] args) {
//
//        Inet4Address inet4Address = null;
//
//        try{
//
//            inet4Address = (Inet4Address) inet4Address.getByName("www.baidu.com");
//        }catch (Exception e){
//            System.exit(2);
//
//        }
//        System.out.println(inet4Address.getHostName() + "=" + inet4Address.getHostAddress());
//
//
//        URLConnection urlConnection =null;
//        try {
//            URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
//             urlConnection = url.openConnection();
//            int size = urlConnection.getContentLength();
//            if(size>0){
//                System.out.println("文件大小："+size+" bytes");
//            }else{
//
//                System.out.println("获取失败");
//            }
//
//        } catch (MalformedURLException e) {
//            System.out.println("获取失败");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.out.println("获取失败");
//            e.printStackTrace();
//        }finally {
//            try {
//                urlConnection.getInputStream().close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.exit(0);
//    }
//}
