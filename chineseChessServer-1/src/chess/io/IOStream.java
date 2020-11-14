package chess.io;

import chess.server.ChessServer;

import java.io.*;
import java.net.Socket;

/**
 * @PackgeName: chess.io
 * @ClassName: IOStream
 * @Author: XuWen
 * Date: 2020/10/28 13:06
 * Introduce:封装流
 */
public class IOStream {

    /**
     * 读消息
     * @param socket    连接的客户端
     * @return  返回读取的对象
     */
    public static Object readMessage(Socket socket){
        Object obj = null;
        try {
            InputStream is = socket.getInputStream();//这也会造成阻塞,把主线程给阻塞了
            ObjectInputStream ois  = new ObjectInputStream(is);//对象输入流
            obj = ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            //如果客户端关闭了，就要再服务器中去处该socket
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // e.printStackTrace();
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
