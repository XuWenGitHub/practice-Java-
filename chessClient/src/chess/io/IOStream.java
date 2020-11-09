package chess.io;

import java.io.*;
import java.net.Socket;

/**
 * @PackgeName: chessClient.io
 * @ClassName: IOStream
 * @Author: XuWen
 * Date: 2020/10/28 13:15
 * Introduce:   把IO流中对象的读和写封装一下
 */
public class IOStream {

    /**
     * IO流读取数据
     * @param socket    客户端
     * @return  读取的内容
     */
    public static Object readMessage(Socket socket){
        Object obj = null;
        try {
            InputStream is = socket.getInputStream();//这也会造成阻塞,把主线程给阻塞了
            ObjectInputStream ois  = new ObjectInputStream(is);//对象输入流
            obj = ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return obj;
    }

    /**
     * 写数据
     * @param socket    连接的客户端
     * @param obj   写的内容
     */
    public static void writeMessage(Socket socket,Object obj){
        try {
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
