package practice.two;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @PackgeName: practice.two
 * @ClassName: TestBlockingNIO2
 * @Author: XuWen
 * Date: 2020/11/4 21:48
 * Introduce:
 */
public class TestBlockingNIO2 {
    //客户端
    public void client(){
        try {
            //开启一个通道
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
            //SocketAddress address = new InetSocketAddress("127.0.0.1",8787);
            //socketChannel.bind(address);

            //文件读取通道
            FileChannel inChannel = FileChannel.open(Paths.get("1.txt"), StandardOpenOption.READ);

            ByteBuffer allocate = ByteBuffer.allocate(1024);

            while (inChannel.read(allocate)!=-1){
                allocate.flip();
                socketChannel.write(allocate);
                allocate.clear();
            }

            socketChannel.shutdownOutput();

            //接受服务器的反馈
            int len=0;
            while ((len=socketChannel.read(allocate))!=-1){
                allocate.flip();
                System.out.println(new String(allocate.array(),0,len));
                allocate.clear();
            }

            inChannel.close();
            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务端
    public void server(){
        try {
            ServerSocketChannel ssChannel = ServerSocketChannel.open();
            ssChannel.bind(new InetSocketAddress(8888));

            FileChannel outChannel = FileChannel.open(Paths.get("xuwen1.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            SocketChannel socketChannel = ssChannel.accept();

            ByteBuffer allocate = ByteBuffer.allocate(1024);
            while(socketChannel.read(allocate)!=-1){
                allocate.flip();
                outChannel.write(allocate);
                allocate.clear();
            }

            //发送反馈给客户端
            allocate.put("服务端接受客户端成功".getBytes());
            allocate.flip();
            socketChannel.write(allocate);

            socketChannel.close();
            outChannel.close();
            ssChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestBlockingNIO2 nio2 = new TestBlockingNIO2();
        new Thread(nio2::server).start();

        new Thread(nio2::client).start();
    }
}
