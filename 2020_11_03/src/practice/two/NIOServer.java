package practice.two;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @PackgeName: practice.two
 * @ClassName: NIOServer
 * @Author: XuWen
 * Date: 2020/11/3 15:18
 * Introduce:
 */
public class NIOServer {
    public static void main(String[] args) {
        try {
            //创建ServerSocketChannel通道，绑定监听端口为8888
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8888);
            serverSocketChannel.bind(socketAddress);
            serverSocketChannel.configureBlocking(false);   //设置通道为非阻塞
            //注册选择器，设置选择器选择的操作类型
            Selector selector = Selector.open();
            //将服务器注册在selector中，用于监听
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                //选择事件，这里会阻塞
                selector.select();  //如果没有任何事件可以处理，则该方法处于阻塞状态
                Set<SelectionKey> selectionKeys = selector.selectedKeys();  //拿到需要处理的事件
                Iterator<SelectionKey> iterator = selectionKeys.iterator(); //遍历需要处理的事件
                while (iterator.hasNext()){
                    System.out.println("处理事件");
                    System.out.println("-----"+selectionKeys.size()+"------");
                    SelectionKey next = iterator.next();    //拿到一个事件
                    iterator.remove();  //再从处理的事件去删除该事件
                    if(next.isReadable()){  //判断当前事件是否是读取操作
                        System.out.println("接受到数据读取操作");
                        //接受到数据读取事件
                        SocketChannel channel = (SocketChannel)next.channel();
                        ByteBuffer dest = ByteBuffer.allocate(1024);
                        int read = channel.read(dest);
                        if(read>0) {    //表示读取到数据了
                            System.out.println(new String(dest.array(), 0, read));
                            //给客户端写数据
                            ByteBuffer d = ByteBuffer.allocate(1024);
                            d.put("我是爸爸".getBytes());
                            channel.write(dest);
                        }else if(read==-1){ //表示该客户端断开连接了
                            channel.close();
                        }
                    }else if(next.isAcceptable()){  //
                        System.out.println("连接请求操作");
                        SocketChannel accept = serverSocketChannel.accept();
                        accept.configureBlocking(false);    //设置客户端对象为非阻塞
                        //接收到请求，将连接注册到选择器中，并且设置监听类型为read
                        accept.register(selector,SelectionKey.OP_READ);
                    }else if(next.isWritable()){
                        System.out.println("写数据事件");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
