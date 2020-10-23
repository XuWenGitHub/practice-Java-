package practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @PackgeName: practice
 * @ClassName: TCPClient
 * @Author: XuWen
 * Date: 2020/10/20 22:10
 * Introduce:
 */
public class TCPClient implements Runnable{
    private volatile Socket socket = null;
    private String name;    //客户端的名字

    public TCPClient(String host,int port,String name){
        try {
            socket = new Socket(host,port);
            this.name = name;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //客户端已连接就可以发消息给服务器，但是要新开一个线程
        new Thread(new sendMessage()).start();

        //下面执行，客户端读取服务器发的消息显示到控制台
        try {
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while(socket!=null&&!socket.isClosed()&&socket.isConnected()&&(len=is.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class sendMessage implements Runnable{

        @Override
        public void run() {
            //写操作
            Scanner sc = null;
            OutputStream os = null;
            try {
                sc = new Scanner(System.in);
                os = socket.getOutputStream();
                String in = name+"：";
                StringBuilder out = new StringBuilder();
                String flag = "";
                do {
                    flag = sc.nextLine();
                    out = new StringBuilder(flag);
                    out.insert(0, in);
                    os.write(out.toString().getBytes());
                    os.flush();
                }while (!flag.equals("bye"));
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                assert sc != null;
                sc.close();
                try {
                    assert os != null;
                    os.close();
                    socket.close();
                    socket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
