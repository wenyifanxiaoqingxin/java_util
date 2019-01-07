package Demo.Test.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by fx on 2019/1/4.
 */
public class M2MSend extends Thread {

    //用户集合
    private ArrayList<Socket> list = SocketServer.getList();
    //当前用户
    private Socket s;

    public M2MSend(Socket s){
        this.s = s;
    }

    public void run(){

        //获取该用户 IP
        String ip = s.getInetAddress().getHostAddress();

        try {

            //读取用户信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //不断的读取写出数据
            while(true){

                //接收数据
                String info = null;

                //如果读取信息不为空
                if((info=reader.readLine()) != null){

                    //遍历所有的在线用户,并且把信息发送过去
                    for(Socket ss : list){
                        if(s!=ss){
                            //获取对象的输出流
                            PrintWriter pw;
                            pw = new PrintWriter(ss.getOutputStream());
                            //写入信息
                            pw.println(ip + " 说: " + info);
                            pw.flush();
                        }


                    }

                }
            }

        } catch (IOException e1) {
            //用户下线
            list.remove(s);
            System.err.println(ip + " 已下线 , 当前在线人数为: " + list.size() + " 人 !");
        }


    }

}
