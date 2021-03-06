package chess.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * @PackgeName: chess.server
 * @ClassName: ChessServer
 * @Author: XuWen
 * Date: 2020/10/28 10:26
 * Introduce:
 */
public class ChessServer {
    //定义一个Map，存放用户名对应的Socket
    //每次客户端登录请求服务器验证的时候，添加进来
    public static Map<String,Socket> userSocketMap = new HashMap<>();

    //存放所有在线的人数
    //每次客户端登录请求服务器验证的时候，添加进来
    public static List<String> users = new ArrayList<>();

    //正在准备游戏等待的人的数量
    //这里要用set集合，因为如果一个玩家，连续点击两次，就存了两个一样的
    //那样就出现错误了
    public static List<String> readyUsers = new ArrayList<>();

    public static void main(String[] args) {
        //实现服务器端
        try {
            //开启服务
            ServerSocket server = new ServerSocket(8888);
            //监听客户端，阻塞方法,返回的是客户端的Socket连接
            //这样的话只能服务一个客户端，所以要添加死循环，去服务其他客户端连接

            while (true){   //服务器端一直监听
                Socket client = server.accept();

                //开辟一个新的线程去处理当前的Socket
                //从Socket通道中获取输入流，里面携带数据
                ServerThread serverThread = new ServerThread(client);
                serverThread.start();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
