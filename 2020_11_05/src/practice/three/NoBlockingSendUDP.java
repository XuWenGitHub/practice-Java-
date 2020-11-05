package practice.three;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @PackgeName: practice.three
 * @ClassName: NoBlockingUDP
 * @Author: XuWen
 * Date: 2020/11/5 17:01
 * Introduce:UDP中的发送端
 */
public class NoBlockingSendUDP {
    public void send(){
        try {
            DatagramChannel dc = DatagramChannel.open();

            dc.configureBlocking(false);

            ByteBuffer buf = ByteBuffer.allocate(1024);

            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()){
                String str = sc.next();
                buf.put((new Date().toString()+"\n"+str).getBytes());
                buf.flip();
                dc.send(buf,new InetSocketAddress("127.0.0.1",8888));
                buf.clear();
            }
            dc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new NoBlockingSendUDP().send();
    }
}
