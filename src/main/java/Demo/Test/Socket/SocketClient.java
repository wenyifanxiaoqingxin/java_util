package Demo.Test.Socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by fx on 2018/2/6.
 */
public class SocketClient {

    public static void main(String[] args){

        try {
            Socket client = new Socket("localhost",6066);
            System.out.println("远程主机地址："+client.getRemoteSocketAddress());
            OutputStream outputStream=client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("hai i am from"+client.getLocalSocketAddress());


            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println("服务器回应："+dataInputStream.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
