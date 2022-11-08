package ssm.util;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author fanxiao3
 * @className WeiXinUtil
 * @description TODO
 * @date 2022/11/8 10:51 上午
 */
public class WeiXinUtil {
    private static final OkHttpClient clientWeiXin = new OkHttpClient();

    public static final String APPID="wxe3c616920edf1b60";
    public static final String APPSECRET="aa5e9b1716a67110015b69c0df6d3d2c";
    public static final String access_token ="62_t02pkCDkmwCoQilDdNaVOiXu-2tBC9Pp_2s4To8DZFoqogU2NSFGBWqGZwSAPKO92cmSnnAB-vS2SiYVAz7U5CslSC0_SIp0DD54UKNfzQUMPyyV_8z9mnvL8q9vAm90f1GLgXrKo1glfR4lSOXbAFAWSB";
    public  static final String weiXinUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
    public static void getData() throws IOException {
        String requestUrl = weiXinUrl + "&appid="+APPID+"&secret="+APPSECRET;
        Request request = new Request.Builder()
                .url(requestUrl)
                .header("Accept", " application/json, text/plain, */*")
                .header("Content-type","application/json")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .header("Connection", "keep-alive")
                .header("Host", "www.114yygh.com")
                .header("Request-Source", "PC")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .header("sec-ch-ua-platform", "macOS")
                .header("User-Agent", "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .post(RequestBody.create(MediaType.parse("application/json"), ""))
                .build();
        Response response = clientWeiXin.newCall(request).execute();
        String res = response.body().string();
        System.out.println("res:"+res);
    }


}
