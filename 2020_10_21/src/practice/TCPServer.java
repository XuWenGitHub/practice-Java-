package practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PackgeName: practice
 * @ClassName: TCPServer
 * @Author: XuWen
 * Date: 2020/10/20 17:59
 * Introduce:   实现一个服务器，多人聊天室
 * 服务器一直监听着，如果有客户端想要连接的话，服务器会给他单独开一个服务它的线程，然后立马又去监听
 */
public class TCPServer implements Runnable{
    private ServerSocket server = null;
    //维护一个有弹性的线程池，有任务就会开启一个新的线程执行，
    //如果有线程空闲，就会去执行任务，不会空闲，如果空闲60秒，该线程会自动销毁
    private ExecutorService threadPool = null;
    //同步容器
    private CopyOnWriteArrayList<Socket> sockets = null;    //去装连接后的客户端

    //构造方法,开启服务器，只需要一个端口，ip系统会自己找自己主机的ip
    public TCPServer(int port){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        threadPool = Executors.newCachedThreadPool();
        sockets = new CopyOnWriteArrayList<>();
    }

    //该服务器也是一个单独的线程,只用来连接
    @Override
    public void run() {
        try {
            System.out.println("服务器已开启~~~");
            while (true) {
                //accept是一个阻塞方法，等到有用户连接才往下走
                Socket socket = server.accept();
                //在服务器显示连接上的电脑
                String message = socket.getInetAddress().getHostAddress();
                System.out.println(message+"连接上了");
                message+="上线";
                //向其他用户发送当前IP地址为多少的上线了
                sendMessageSockets(message);
                //把连接上的用户添加到集合：里面去
                sockets.add(socket);
                //线程池中拿一个线程去读取该线程发送的消息，然后再发送给其他客户端
                threadPool.execute(new readerTask(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //给所有客户端发送信息
    private void sendMessageSockets(String message){
        OutputStream os = null;
        for(Socket socket:sockets){
            if(socket!=null&&socket.isConnected()&&!socket.isClosed()){
                try {
                    os = socket.getOutputStream();
                    os.write(message.getBytes());
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //写一个读取客户信息的任务类
    class readerTask implements Runnable{
        InputStream is = null;
        Socket socket = null;
        //这里需要传入一个socket对象，因为每一个用户都要用一个不同的线程去读该客户端写的东西
        public readerTask(Socket socket){
            try {
                this.socket = socket;
                is = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            try {
                byte[] bytes = new byte[1024];
                int len=0;
                while (socket!=null&&!socket.isClosed()&&socket.isConnected()&&(len=is.read(bytes))!=-1){
                    //把读取到的数据发送给其他用户
                    sendMessageSockets(new String(bytes,0,len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
