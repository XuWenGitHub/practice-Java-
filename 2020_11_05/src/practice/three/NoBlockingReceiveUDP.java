package practice.three;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @PackgeName: practice.three
 * @ClassName: NoBlockingReceiveUDP
 * @Author: XuWen
 * Date: 2020/11/5 17:26
 * Introduce:UDP中的接收端
 */
public class NoBlockingReceiveUDP {
    public void receive(){
        try {

            DatagramChannel dc = DatagramChannel.open();
            dc.configureBlocking(false);
            dc.bind(new InetSocketAddress(8888));

            Selector selector = Selector.open();

            dc.register(selector, SelectionKey.OP_READ);

            while(selector.select()>0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    if(next.isReadable()){
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        dc.receive(buf);
                        buf.flip();
                        System.out.println(new String(buf.array(),0,buf.limit()));
                    }

                    iterator.remove();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NoBlockingReceiveUDP().receive();
    }
}
