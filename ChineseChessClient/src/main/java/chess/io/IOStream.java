package chess.io;

import chess.entity.User;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.Socket;

/**
 * @PackgeName: chessClient.io
 * @ClassName: IOStream
 * @Author: XuWen
 * Date: 2020/10/28 13:15
 * Introduce:   用JSONFAST序列化来序列化对象传输,用JSONFAST反序列化来反序列化对象传输
 */
public class IOStream {

    /**
     * IO流读取数据
     * @param socket    客户端
     * @return  读取的内容
     */
    public static Object readMessage(Socket socket){

        User obj = null;
        try {
            InputStream is = socket.getInputStream();//这也会造成阻塞,把主线程给阻塞了
            byte[] bys = new byte[1024];
            int len=0;
            len=is.read(bys);
            String str = new String(bys,0,len);

            obj = JSON.parseObject(str, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读取到的消息："+obj);
        return obj;
    }

    /**
     * 写数据
     * @param socket    连接的客户端
     * @param obj   写的内容
     */
    public static void writeMessage(Socket socket,Object obj){
        String str = JSON.toJSONString(obj);
        System.out.println(str);
        try {
            OutputStream os = socket.getOutputStream();
            os.write(str.getBytes());

//            ObjectOutputStream oos = new ObjectOutputStream(os);
//            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
