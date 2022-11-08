package ssm.getData114;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;
import ssm.util.WeiXinUtil;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author fanxiao3
 * @className getDataForm114
 * @description TODO
 * @date 2022/11/7 3:11 下午
 */
public class getDataFrom114 {
    private static final OkHttpClient client = new OkHttpClient();
    private static final String url = "https://www.114yygh.com/web/product/detail?_time=";
    private static final String body ="{\"firstDeptCode\":\"5e9ebbd6341e9c7c15f668fbf11d3711\",\"secondDeptCode\":\"200001078\",\"hosCode\":\"125\",\"target\":\"2022-11-18\"}";
    public static void main(String[] args) throws IOException {
        getData();
        showTimer();
    }

    public static boolean getData() throws IOException {
        boolean result = true;
        String  dataStr = String.valueOf(System.currentTimeMillis());
        String requestUrl = url+dataStr;
        String tempBody = String.format(body);
        Request request = new Request.Builder()
                .url(requestUrl)
                .header("Cookie", "imed_session=yAi5k1M6zB7iLC7CtVQm9Sxz76zCGeem_5559561; secure-key=fcf0ed79-235d-4c50-8637-0fed918779dc; imed_session=yAi5k1M6zB7iLC7CtVQm9Sxz76zCGeem_5559561; agent_login_img_code=1338292b342144f29048c7e992b3186e; cmi-user-ticket=_Nr5fwIM-BhHCkvYaMTkQf45pNAUXFnCIr06Rw..; imed_session_tm=1667868523194")
                .header("Accept", " application/json, text/plain, */*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .header("Connection", "keep-alive")
                .header("Host", "www.114yygh.com")
                .header("Request-Source", "PC")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
                .header("sec-ch-ua-platform", "macOS")
                .header("Referer", "https://www.114yygh.com/hospital/125/5e9ebbd6341e9c7c15f668fbf11d3711/200001078/source")
                .header("User-Agent", "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .post(RequestBody.create(MediaType.parse("application/json"), tempBody))
                .build();
        Response response = client.newCall(request).execute();
        String res = response.body().string();
        System.out.println("返回结果：\n"+res);

        if(StringUtils.isEmpty(res) ){
            System.out.println("未查询到数据");
            return false;
        }
        Resp resp = new Resp();
        resp = JSON.parseObject(res, Resp.class);
        if(CollectionUtils.isEmpty(resp.getData())){
            System.out.println("未查询到数据");
            return false;
        }
        boolean isCanPresale = false;
        for(RespDataInfo respDataInfo : resp.getData()){
            if(!"MORNING".equals(respDataInfo.getDutyCode())){
                continue;
            }
            for(DoctorInfo doctorInfo : respDataInfo.getDetail()){
                if(!"张爱玲".equals(doctorInfo.getDoctorName())){
                    continue;
                }
                isCanPresale =  (doctorInfo.getWnumber() %2 !=0);
                if(isCanPresale){
                    break;
                }

            }
        }
        String msg = isCanPresale ? "" : "不";
        System.out.println("张爱玲医生"+ msg + "可以挂号");
        return result;
    }

    static int count = 0;

    public static void showTimer() {

        TimerTask task = new TimerTask() {

            @Override

            public void run() {

                ++count;
                try {
                    boolean result = getData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("时间=" + new Date() + " 执行了" + count + "次");
            }

        };
        //设置执行时间

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);

        int month = calendar.get(Calendar.MONTH);

        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天

        //定制每天的21:09:00执行，

        calendar.set(year, month, day, 9, 00, 00);

        Date date = calendar.getTime();

        Timer timer = new Timer();

        System.out.println(date);

        int period = 10 * 1000;

        //每天的date时刻执行task，每隔2秒重复执行

        timer.schedule(task, date, period);

        //每天的date时刻执行task, 仅执行一次

        //timer.schedule(task, date);

    }
}
