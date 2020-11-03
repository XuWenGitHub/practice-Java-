package practice.one;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: practice.one
 * @ClassName: TomcatServer
 * @Author: XuWen
 * Date: 2020/11/2 23:45
 * Introduce:nio的思想
 */
//自己模拟nio
public class TomcatServer {
    //分配一个512字节的缓冲区
    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);
    //创建一个存放客户端对象的服务器
    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            //创建服务器对象
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            //没有协议附件的套接字地址
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8888);
            //结合通道的插座到本地地址和配置套接字监听连接
            serverSocket.bind(socketAddress);
            //调整这个通道的阻塞模式为非阻塞
            serverSocket.configureBlocking(false);
            //用单线程处理并发
            while (true){
                //遍历服务器中所有的客户端
                //去读一次客户端的写入，如果读取到了，处理数据，没有读取到，不管
                /**
                 * 有一个问题，这个循环，如果有10000个客户端连接了
                 * 但是1000个服务器给客户端发了消息，
                 * 就会浪费9000次循环没有意义
                 * java--jvm--os
                 * 所以这个for循环就应该再引用程序去执行，应该去内核去执行
                 * 就是os去执行，那么就快的多
                 *
                 * 这个for循环中无意义的循环，如何去避免呢？
                 * 目前还没有完美的解决方案，但是有两种
                 * 这个两个函数都是操作系统给出的函数
                 * windows下（1）selector，就是把循环交给os内核操作系统去执行
                 * int select(int nfds,fd_set *readds,fs_set *writeds,fs_set *exceptfds,struct timeval *timeout);
                 * linux下（2）epoll，告诉你哪些有事件，但是还是要轮循
                 *
                 * epoll比selector更加的高效
                 * redis键值对数据库，底层就是用的epoll函数，所以官网都是Linux系统下的安装，
                 * 但是有些大佬把redis中的epoll改成window下的selector
                 */
                for(SocketChannel socketChannel:channelList){
                    int read = socketChannel.read(byteBuffer);
                    if(read>0){ //客户端发来的消息,已经读取到字节缓冲区
                        System.out.println("read-----------1111-----"+read);
                        //翻转这个缓冲区。将限制设置为当前位置，然后将位置设置为零。如果标记被定义，那么它将被丢弃
                        byteBuffer.flip();
                        byte[] bytes = new byte[read];
                        //把数据读取到bytes中
                        byteBuffer.get(bytes);
                        String readDate = new String(bytes);
                        System.out.println(readDate);
                        ////翻转这个缓冲区。将限制设置为当前位置，然后将位置设置为零。如果标记被定义，那么它将被丢弃
                        byteBuffer.flip();
                    }else if(read==-1){ //表示断开连接了
                        //就把当前客户端从服务器中存储已连接客户端对象的list中删除掉
                        channelList.remove(socketChannel);
                    }
                }
                //服务器去看有木有客户端连接，如果没有就为null
                SocketChannel accept = serverSocket.accept();
                if(accept!=null){
                    System.out.println(accept.getLocalAddress()+"连接~~~");
                    channelList.add(accept);
                    System.out.println(channelList.size()+"list---size");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
