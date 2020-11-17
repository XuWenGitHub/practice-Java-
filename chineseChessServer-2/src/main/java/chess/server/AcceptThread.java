package chess.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class AcceptThread implements Runnable{
    private final ServerSocketChannel serverSocketChannel;
    private final Selector selector;

    public AcceptThread(ServerSocketChannel serverSocketChannel, Selector selector) {
        this.serverSocketChannel = serverSocketChannel;
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            System.out.println("接受连接");
            //10.若"接受就绪"，获取客户端连接
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println(socketChannel);
            if(socketChannel==null){
                return;
            }
            System.out.println(socketChannel);
            //System.out.println(socketChannel);
            //11.注意！！切换连接的客户端通道为非阻塞模式
            socketChannel.configureBlocking(false);

            //12.将该通道注册到选择器上
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
