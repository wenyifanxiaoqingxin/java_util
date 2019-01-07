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
public class M2MSendAll extends Thread{
    //用户集合
    private ArrayList<Socket> list = SocketServer.getList();

    @Override
    public void run() {
        String info =null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag =true;
        try {
            while(flag){
                if((info=bufferedReader.readLine())!=null){
                    for(Socket socket1:list){
                        PrintWriter pw2 = new PrintWriter(socket1.getOutputStream());
                        pw2 = new PrintWriter(socket1.getOutputStream());
                        //写入信息
                        pw2.println("服务器"+ "说: " + info);
                        pw2.flush();

                    }

                }
                //服务器输入shutdown会终止线程
                if("shutdown".equals(info)){
                    flag = false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}