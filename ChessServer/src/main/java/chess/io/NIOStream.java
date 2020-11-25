package chess.io;

import chess.entity.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOStream {
    /**
     * 读消息（利用JSONObject去反序列化对象)
     * @param socketChannel 连接并且已准备好发送的客户端通道
     * @return  JSONfast反序列化后的对象
     */
    public static User readMessage(SocketChannel socketChannel){
        String str = null;
        User user = null;
        try {

            //创建读的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int len = 0;
            len = socketChannel.read(buf);
            str = new String(buf.array(),0,len);
            user= JSONObject.parseObject(str,User.class);

        } catch (IOException e) {
            e.printStackTrace();
            //随便处理的，如果专业处理，需要分情况（1）正常玩家退出（2）玩家异常退出
//            try {
//                socketChannel.close();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
        }
        return user;
    }


    /**
     * 写数据
     * @param socketChannel 客户端套接字
     * @param obj   需要传的对象
     */
    public static void writeMessage(SocketChannel socketChannel,Object obj){
        String str = JSON.toJSONString(obj);
        try {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(str.getBytes());
            buf.flip();
            if(socketChannel!=null) {
                socketChannel.write(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
