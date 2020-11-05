package practice.two;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @PackgeName: practice.two
 * @ClassName: NoBlockingClient
 * @Author: XuWen
 * Date: 2020/11/4 22:14
 * Introduce:   非阻塞客户端NIO
 */
public class NoBlockingClient {
    //客户端
    public void client(){
        try {
            //1.获取通道
            SocketChannel socketChannel =  SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));

            //2、切换成非阻塞模式
            socketChannel.configureBlocking(false);

            //3.分配一个指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //4.给缓冲区添加数据
            //buf.put(new Date().toString().getBytes());

            //5.给客户端发送数据
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String str = sc.next();
                buf.put((new Date().toString()+"\n"+str).getBytes());
                buf.flip(); //切换缓冲区读取
                socketChannel.write(buf);   //给服务器把缓冲区数据写过去
                buf.clear();    //清空缓冲区
            }

            //6.关闭通道
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NoBlockingClient().client();
    }
}
