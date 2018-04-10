package Demo.Test.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fx on 2018/2/6.
 */
public class SocketServerThread extends Thread{

    private ServerSocket serverSocket;
    public SocketServerThread(int port) throws IOException {

        serverSocket = new ServerSocket(port);
//        serverSocket.setSoTimeout(10000);
    }
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("等待远程连接，端口号为："+serverSocket.getLocalPort()+"...");

                Socket socket = serverSocket.accept();
                System.out.println("远程主机地址："+socket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println(dataInputStream.readUTF());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("连接成功"+socket.getLocalSocketAddress());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args){

        int port = Integer.parseInt("6066");

        try {
            Thread t = new SocketServerThread(port);
            t.start();
        }catch (Exception e){


            e.printStackTrace();
        }

    }
}
