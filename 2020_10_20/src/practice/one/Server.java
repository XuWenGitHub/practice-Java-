package practice.one;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @PackgeName: practice.one
 * @ClassName: Server
 * @Author: XuWen
 * Date: 2020/10/20 9:33
 * Introduce:
 * 服务器再每一台客户端登录的时候：在服务器端显示连接上的客户端主机地址
 * 服务器可以一直接收客户端的短信
 * 服务器也可以一直给连接后的客户端一直发消息
 * 客户端可以一直接受服务器的消息
 * 客户端也可以一直给连接后的客户端一直发消息
 */
public class Server extends Thread{
    //定义服务器接口ServerSocket
    ServerSocket server = null;
    //定义一个服务器，定义端口
    public Server(int port){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //发送消息的线程
    @Override
    public void run() {
        try {

            System.out.println("服务器在启动中...等待用户的连接");

            //一直接受用户的连接，连接之后发送一条短信给用户
            while (true) {
                //建立socket接口，accept方法是一个阻塞进程，
                Socket socket = server.accept();
                //在服务器上显示连接的上的电脑
                System.out.println(socket.getInetAddress().getHostAddress() + "正在连接");

                //服务器给客户端发送消息
                new Thread(new SendMessage(socket)).start();

                //通过socket对象可以获得输入流，用来读取用户数据
                InputStream is = socket.getInputStream();
                //读取数据
                int len = 0;
                byte[] buf = new byte[1024];
                while ((len = is.read(buf)) != -1) {
                    //直接把获得的数据打印出来
                    System.out.println(new String(buf, 0, len));
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //给客户端发消息的类（实现了Runnable接口）
    static class SendMessage implements Runnable{
        //通过socket对象可以获得输出流，用来写数据
        OutputStream os = null;
        Scanner sc = null;
        Socket socket = null;
        public SendMessage(Socket s){
            socket = s;
        }
        @Override
        public void run() {
            try {
                os = socket.getOutputStream();
                do {
                    //System.out.println("请输入发送给客户端的消息:");
                    sc = new Scanner(System.in);
                    String s = "服务器：" + sc.nextLine();

                    //向客户端发送消息
                    //os.write("服务器正在向你发送消息!".getBytes());
                    os.write(s.getBytes());
                }while (true);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        //这里服务器只需要定义一个端口号就可以了，程序会自动获取IP地址
        //但是客户端需要连接这个服务器时没需要知道它的IP地址还有端口号
        //ip地址的查看方式：ipconfig-》cmd窗口
        Server server = new Server(8888);
        server.start();
    }
}
