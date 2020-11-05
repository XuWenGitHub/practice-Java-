package practice.four;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @PackgeName: practice.four
 * @ClassName: Pipe
 * @Author: XuWen
 * Date: 2020/11/5 17:45
 * Introduce:通过单向管道发送数据
 */
public class TestPipe {

    public void test1(){
        //1.获取管道
        try {
            //1.获取管道
            Pipe pipe = Pipe.open();

            //2.将缓冲区中的数据写入管道
            ByteBuffer buf = ByteBuffer.allocate(1024);

            Pipe.SinkChannel sinkChannel = pipe.sink();
            buf.put("通过单向管道发送数据".getBytes());
            buf.flip();
            sinkChannel.write(buf);

            //3.读取缓冲区中的数据
            Pipe.SourceChannel sourceChannel = pipe.source();
            buf.flip();
            sourceChannel.read(buf);
            System.out.println(new String(buf.array(),0,buf.limit()));

            sourceChannel.close();
            sinkChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new TestPipe().test1();
    }
}
