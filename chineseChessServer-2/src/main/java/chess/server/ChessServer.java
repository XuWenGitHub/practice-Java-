package chess.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.*;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//多线程
//1.提高效率,一个硬盘，一个cpu，一个输入设备，一个输出设备
//进程：分配资源的最小单位     线程：操作系统调度的最小单位,给它分配的cpu时间片就会多一点，所以就能提高效率

//2.IO是不是会阻塞

/**
 * @PackgeName: chess.server
 * @ClassName: ChessServer
 * @Author: XuWen
 * Date: 2020/10/28 10:26
 * Introduce:
 */
public class ChessServer {
    //定义一个Map，存放用户名对应的Socket
    //每次客户端登录请求服务器验证的时候，添加进来
    public static Map<String,SocketChannel> userSocketMap = new HashMap<>();

    //存放所有在线的人数
    //每次客户端登录请求服务器验证的时候，添加进来
    public static List<String> users = new ArrayList<>();

    //存放对弈两方的姓名
    public static Map<String,String> match = new HashMap<>();

    //正在准备游戏等待的人的数量
    //这里要用set集合，因为如果一个玩家，连续点击两次，就存了两个一样的
    //那样就出现错误了
    //用一个队列来存储准备人的名字，每次poll出两个人来进行匹配
    public static Deque<String> readyUsers = new LinkedList<>();

    //当玩家点击准备后，加入初始化队列，当房主点击开始后，然后服务器给
   // public static Deque<String> initUsers = new LinkedList<>();

    //建造一个线程池，去执行服务器连接和准备连接服务器的客户端的
    public static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        try {
            //1.获取通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            System.out.println(serverSocketChannel);
            //2.切换非阻塞模式IO
            serverSocketChannel.configureBlocking(false);

            //3.绑定连接
            serverSocketChannel.bind(new InetSocketAddress(8888));

            //4.获取一个选择器
            Selector selector = Selector.open();

            //5.将通道注册到选择器上，并制定监听"接受"事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //6.轮询的获取选择器上已经"准备就绪"的事件
            while (selector.select() > 0) {
                //7.获取当前选择器中所有注册的"选择键（已就绪的监听事件)"
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                System.out.println(selectionKeys);
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    //8.获取准备"就绪"的事件
                    SelectionKey next = iterator.next();

                    //9.判断具体是什么事件准备就绪
                    //接受事件就绪了
                    if (next.isAcceptable()) {
                        //接收连接进行事件，表示服务器监听到了客户连接，那么服务器可以接收这个连接了
                        //某个客户端准备就绪的事件为：连接服务器
                        SocketChannel socketChannel = serverSocketChannel.accept();

                        if(socketChannel==null){
                            return;
                        }
                        System.out.println(socketChannel);
                        //11.注意！！切换连接的客户端通道为非阻塞模式
                        socketChannel.configureBlocking(false);

                        //12.将该通道注册到选择器上
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (next.isReadable()) {    //某个客户端发来了消息
                        System.out.println("客户端发来消息");
                        //读就绪事件，表示通道中已经有了可读的数据，可以执行读操作了（通道目前有数据，可以进行读操作了）
                        //客户端准备就绪的事件为：客户端发来了操作
                        //先根据
                        //13.获取当前选择器上"读就绪"状态的通道
                        SocketChannel socketChannel = (SocketChannel) next.channel(); //返回此键被创建的通道。

                        //开启一个线程去处理客户端发来的消息
                        threadPool.execute(new ReadableThread(socketChannel));
                    }else if(next.isConnectable()){

                        System.out.println("已连接成功");
                    }

                    //15.取消选择键 SelectionKey
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
