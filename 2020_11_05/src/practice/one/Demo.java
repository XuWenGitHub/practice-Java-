package practice.one;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/4 16:23
 * Introduce:通道（Channel），用于源节点和目标节点的连接。
 * 在javaNIO中负责缓冲区中数据的传输
 * Channel本身不存数据，因此需要配合缓冲区进行传输
 *
 */
public class Demo {
    //1.利用通道完成文件的复制
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("1.txt");
        FileOutputStream fos = new FileOutputStream("2.txt");

        //获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);

        //将通道中的数据存入缓冲区
        while (inChannel.read(allocate)!=-1){
            allocate.flip();    //切换成读取数据的模式
            //将缓冲区中的数据写入通道中
            outChannel.write(allocate);
            allocate.clear();
        }

        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
    }
}
