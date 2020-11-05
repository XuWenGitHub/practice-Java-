package practice.two;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @PackgeName: practice.two
 * @ClassName: NoBlockingServer
 * @Author: XuWen
 * Date: 2020/11/4 22:14
 * Introduce:非阻塞服务器（NIO）
 */
public class NoBlockingServer {
    //服务端
    public void server(){
        try {
            //1.获取通道
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            //2.切换非阻塞模式
            serverSocketChannel.configureBlocking(false);

            //3.绑定连接
            serverSocketChannel.bind(new InetSocketAddress(8888));

            //4.获取一个选择器
            Selector selector = Selector.open();    //选择器用来监听通道

            //5.将通道注册到选择器上,并且制定"监听接受事件"
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //6.轮询式的获取选择器上已经"准备就绪"的事件
            while (selector.select()>0){
                //7.获取当前选择器中所有注册的"选择键（已就绪的监听事件)"
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()){
                    //8.获取准备"就绪"的事件
                    SelectionKey next = iterator.next();

                    //9.判断具体是什么事件准备就绪
                    if(next.isAcceptable()){//接受事件就绪了
                        //10.若"接受就绪"，获取客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();

                        //11.注意！！切换连接的客户端通道为非阻塞模式
                        socketChannel.configureBlocking(false);

                        //12.将该通道注册到选择器上
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if(next.isReadable()){    //某个客户端发来了消息
                        //13.获取当前选择器上"读就绪"状态的通道
                        SocketChannel socketChannel = (SocketChannel) next.channel(); //返回此键被创建的通道。

                        //14.读取数据
                        ByteBuffer buf = ByteBuffer.allocate(1024);

                        int len = 0;
                        while ((len = socketChannel.read(buf))>0){
                            buf.flip();
                            System.out.println(new String(buf.array(),0,len));
                            buf.clear();
                        }
                    }

                    //15.取消选择键 SelectionKey
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NoBlockingServer server = new NoBlockingServer();
        server.server();
    }
}
