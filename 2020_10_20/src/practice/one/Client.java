package practice.one;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @PackgeName: practice.one
 * @ClassName: Client
 * @Author: XuWen
 * Date: 2020/10/20 10:16
 * Introduce:   客户端连接上了，会接收到一条短信，并且可以对服务器一直进行发送短信。
 *
 */
public class Client extends Thread{
    //定义一个Socket对象
    Socket socket = null;
    //客户端的构造方法
    public Client(String host,int port){
        //需要服务器的ip地址和端口号，才能获得正确的Socket
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //客户端一连接就可以写数据给服务器了
        //写操作要开启一个新的线程,
        // 因为你在给服务器写的时候，你也可以读取服务器给你写的数据,因为如果不开启一个新的线程，read()是个阻塞方法
        new SendMessThread().start();

        //客户端在该线程中一直读取着服务器发送的消息
        try {
            InputStream is = socket.getInputStream();
            byte[] bys = new byte[1024];
            int len = 0;
            while ((len = is.read(bys)) != -1) {
                System.out.println(new String(bys, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //往服务器里面写数据，需要新开一个线程
    class SendMessThread extends Thread{
        @Override
        public void run() {
            //写操作
            Scanner scanner = null;
            OutputStream os = null;
            try{
                scanner = new Scanner(System.in);
                os = socket.getOutputStream();
                String in="";
                do{
                    //System.out.println("请输入发送给服务器的消息:");
                    in = scanner.nextLine();
                    os.write(("客户端:"+in).getBytes());
                    os.flush();
                }while (!in.equals("bye"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
            try {
                assert os != null;
                os.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client("192.168.1.103",8888);
        client.start();
    }
}
