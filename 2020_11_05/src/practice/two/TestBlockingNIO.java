package practice.two;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @PackgeName: practice.two
 * @ClassName: TestBlockingNIO
 * @Author: XuWen
 * Date: 2020/11/4 21:20
 * Introduce:使用NIO完成网络通信的三个核心
 *      java.nio.channels.Channel接口
 *          --SelectableChannel
 *              --SocketChannel
 *              --ServerSocketChannel
 *              --DatagramChannel
 *
 *              --Pipe.SinkChannel
 *              --Pipe.SourceChannel
 * 1.通道（Channel）负责连接
 *
 * 2.缓冲区（Buffer）负责数据的存取
 *
 * 3.选择器（Selector）是SelectabelChannel 的多路复用器。用于监控SlectabelChannel的IO状况
 */
public class TestBlockingNIO {
    //客户端
    public void client(){
        try {

            //1，获取通道
            SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));

            FileChannel inChannel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);

            //2.分配指定大小的缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(1024);

            //3.读取本地文件，并发送到服务端去
            while(inChannel.read(allocate)!=-1){
                allocate.flip();
                sChannel.write(allocate);
                allocate.clear();
            }

            //关闭通道
            inChannel.close();
            sChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //服务端
    public void server(){
        try {
            //1.获取通道
            ServerSocketChannel ssChannel = ServerSocketChannel.open();

            FileChannel outChannel = FileChannel.open(Paths.get("xuwen.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            //2.绑定连接端口号
            ssChannel.bind(new InetSocketAddress(8888));

            //3.获取客户端的连接通道
            SocketChannel accept = ssChannel.accept();

            //4.分配一个指定大小的缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(1024);

            //5.接受客户端发送过来的数据
            while (accept.read(allocate)!=-1){
                allocate.flip();
                outChannel.write(allocate);
                allocate.clear();
            }

            //6.关闭通道
            accept.close();
            outChannel.close();
            ssChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestBlockingNIO nio = new TestBlockingNIO();
        new Thread(nio::client).start();
        nio.server();


    }
}
