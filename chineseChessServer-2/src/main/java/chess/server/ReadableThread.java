package chess.server;

import chess.entity.User;
import chess.io.IOStream;
import chess.io.NIOStream;
import chess.mysql.Check;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 处理服务器接收到客户端已经传过来的数据
 */
public class ReadableThread implements Runnable {
    SocketChannel socketChannel = null;

    public ReadableThread(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {



        //这一行一直等待客户端发过来的消息，会产生阻塞
        //Object obj = IOStream.readMessage(socket);//读取客户端发送的内容
        User obj = NIOStream.readMessage(socketChannel);
        System.out.println("服务器端接受消息：" + obj);
        //System.out.println(obj.getStatus());

        if (obj != null) {
            //这个下面的代码是做登录的，现在要去做准备，
            // 我们需要根据消息分类来确定干什么
            User.StatusEnum status = ((User) obj).getStatus();  //确定客户端进行什么操作
            if (status == User.StatusEnum.LOGIN) {    //做登录操作
                //做登录操作
                loginProcess((User) obj);
            } else if (status == User.StatusEnum.READY) {  //做准备操作
                //准备操作
                readyProcess((User) obj);
            } else if (status == User.StatusEnum.START) {
                //开始操作
                startProcess((User) obj);
            } else if (status == User.StatusEnum.RUN) {
                //走棋操作
                runProcess((User) obj);
            } else if (status == User.StatusEnum.HQSQ) {
                //悔棋申请操作
                hqsqProcess((User) obj);
            } else if (status == User.StatusEnum.REJECT) {
                //不同意悔棋申请
                rejectProcess((User) obj);
            } else if (status == User.StatusEnum.AGREE) {
                //同意悔棋申请
                agreeProcess((User) obj);
            } else if (status == User.StatusEnum.CHAT) {
                //聊天消息
                chatMsProcess((User) obj);
            } else if (status == User.StatusEnum.DD) {
                //窗口抖动
                ddProcess((User) obj);
            }
            //

        }else {
            System.out.println("读取到obj为null");
        }

    }

    /**
     * 窗口抖动
     *
     * @param user 客户端传来的对象
     */
    private void ddProcess(User user) {
        String username = user.getUsername();
        for (int i = 0; i < 2; i++) {
            String str = null;
            SocketChannel socket = null;
            if (i == 0) {
                str = username;
                socket = ChessServer.userSocketMap.get(str);
            } else {
                str = ChessServer.match.get(username);
                socket = ChessServer.userSocketMap.get(str);
            }
            user.setStatus(User.StatusEnum.DD);
            NIOStream.writeMessage(socket, user);
        }

        //下面是只支持两个客户单
//        int size = ChessServer.users.size();
//        for(int i=0;i<size;i++){
//            String str = ChessServer.users.get(i);
//            Socket socket = ChessServer.userSocketMap.get(str);
//            user.setStatus(User.StatusEnum.DD);
//            IOStream.writeMessage(socket,user);
//        }
    }

    /**
     * 聊天消息转发
     *
     * @param user 客户端发来的对象
     */
    private void chatMsProcess(User user) {

        String username = user.getUsername();   //发送消息方
        //如果客户端还没有准备，就发送消息，那么直接不处理
        //因为客户端如果不准备，就没有匹配对手，服务器就不知道给谁发送消息
        if (!ChessServer.match.containsKey(username)) {
            user.setMatch(false);   //表示当前客户端没有匹配
            NIOStream.writeMessage(ChessServer.userSocketMap.get(username), user);
            return;
        }
//        for(Map.Entry<String,Socket> entry :ChessServer.userSocketMap.entrySet()){
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        //给两个客户端发送消息
        for (int i = 0; i < 2; i++) {
            String str = null;
            SocketChannel socket = null;
            if (i == 0) {
                str = username;
                socket = ChessServer.userSocketMap.get(str);
            } else {
                str = ChessServer.match.get(username);
                socket = ChessServer.userSocketMap.get(str);
            }
//            System.out.println(str);
//            System.out.println("socket:"+socket);
//            System.out.println("user："+user);
            user.setMatch(true);
            NIOStream.writeMessage(socket, user);
        }
        //这是实现两个客户端
//        int size = ChessServer.users.size();
//        for(int i=0;i<size;i++){
//            //此处的消息，需要用户开始之后才能聊天
//            String str = ChessServer.users.get(i);
//            Socket socket = ChessServer.userSocketMap.get(str);
//            IOStream.writeMessage(socket,user);
//        }
    }

    /**
     * 对方同意悔棋操作
     *
     * @param user 客户端发来的消息
     */
    private void agreeProcess(User user) {
        String userName = user.getUsername();
//
//        String str = ChessServer.match.get(userName);
//
//        Socket socket = ChessServer.userSocketMap.get(str);
        //给对弈两方发送消息
        for (int i = 0; i < 2; i++) {
            //获取对弈对方的姓名
            String str = null;
            //获取对弈对方的Socket通道
            SocketChannel socket = null;
            if (i == 0) {
                user.setMoveFlag(false);
                str = userName;
                socket = ChessServer.userSocketMap.get(str);
            } else {
                user.setMoveFlag(true);
                str = ChessServer.match.get(userName);
                socket = ChessServer.userSocketMap.get(str);
            }
            NIOStream.writeMessage(socket, user);
        }
//        int size = ChessServer.readyUsers.size();
//        for(int i=0;i<size;i++){
//            String str = ChessServer.readyUsers.get(i);
//            Socket socket = ChessServer.userSocketMap.get(str);
//            if(!str.equals(userName)){
//                //如果是申请悔棋的那一方，我们就同意悔棋操作
//                user.setMoveFlag(true);
//            }else {
//                user.setMoveFlag(false);
//            }
//            IOStream.writeMessage(socket,user);
//        }
    }

    /**
     * 不同意悔棋申请
     *
     * @param user 客户端传来的对象
     */
    private void rejectProcess(User user) {
        //将不同意悔棋申请发给对方
        String username = user.getUsername();
        //获取对弈对方的姓名
        String str = ChessServer.match.get(username);
        //获取对弈对方的Socket通道
        SocketChannel socket = ChessServer.userSocketMap.get(str);
        NIOStream.writeMessage(socket, user);
//        int size = ChessServer.readyUsers.size();
//        for(int i=0;i<size;i++){
//            String str = ChessServer.readyUsers.get(i);
//            Socket socket = ChessServer.userSocketMap.get(str);
//            if(!str.equals(username)){
//                //给申请悔棋的客户端发送user
//                IOStream.writeMessage(socket,user);
//            }
//        }
    }

    /**
     * 悔棋申请操作
     *
     * @param user 客户端传来的对象
     */
    private void hqsqProcess(User user) {
        //将申请发给对方
        String username = user.getUsername();
        //获取对弈对方的姓名
        String str = ChessServer.match.get(username);
        //获取对弈对方的Socket通道
        SocketChannel socket = ChessServer.userSocketMap.get(str);
        NIOStream.writeMessage(socket, user);
//        int size = 2;
//        for(int i=0;i<2;i++){
//            String str = ChessServer.readyUsers.get(i);
//            Socket socket = ChessServer.userSocketMap.get(str);
//            if(!str.equals(username)){
//                //给不是申请悔棋的客户端发送user
//                IOStream.writeMessage(socket,user);
//            }
//        }
    }

    /**
     * 走棋操作
     *
     * @param user 客户端传来的消息
     */
    private void runProcess(User user) {
        //通知两方去走动棋子
        String userName = user.getUsername();
        //这里只能有两个客户端
        for (int i = 0; i < 2; i++) {
            String str = null;
            SocketChannel socket = null;
            if (i == 0) {
                str = userName;
                //通过姓名去拿到当前客户端的Socket通道
                socket = ChessServer.userSocketMap.get(str);
            } else {
                str = ChessServer.match.get(userName);
                socket = ChessServer.userSocketMap.get(str);
            }
            //user.setUsername(userName);
            if (str.equals(userName)) {
                //这就是下棋的那一方,设置其不能动了
                // user.setUsername(userName); //有username就是下棋那一方
                user.setMoveFlag(false);
                //把数据写回给服务器
                NIOStream.writeMessage(socket, user);
            } else {
                //这就是下棋的对手方，设置其能动了
                // user.setUsername(null);
                user.setMoveFlag(true);
                NIOStream.writeMessage(socket, user);
            }
        }
    }

    /**
     * 开始操作，肯定是房主发来的消息
     *
     * @param user 当前客户端传来的消息
     */
    private void startProcess(User user) {
        //给两个客户端发送消息，开始游戏,点击开始的那个人能动
        //这个是点击开始的那个人
        String username = user.getUsername();   //房主名字

        //当前就只能存两个人
        for (int i = 0; i < 2; i++) {
            String str = null;
            SocketChannel socket = null;
            if (i == 0) {
                str = username;
                socket = ChessServer.userSocketMap.get(str);
            } else {
                str = ChessServer.match.get(username);
                socket = ChessServer.userSocketMap.get(str);
            }
            if (str.equals(username)) {
                //点击开始按钮的那个人
                user.setColor(1);   //表示红方
                user.setMoveFlag(true);
                NIOStream.writeMessage(socket, user);
            } else {
                //不能动的那个人
                user.setColor(2);
                user.setMoveFlag(false);
                NIOStream.writeMessage(socket, user);
            }
        }

//        //这个客户端拥有开始动的能力
//        Socket socket = ChessServer.userSocketMap.get(username);
//        IOStream.writeMessage(socket,user);
    }

    /**
     * 准备操作
     *
     * @param user 当前客户端传来的消息
     */
    private void readyProcess(User user) {
        //第一次客户端点击准备后，服务器这里就已经存入readyUsers了，
        // 然后如果该集合里包含这个，就不能再执行下面的操作，就需要继续等待
        //不然一个客户端点击两次准备之后，因为是List集合，可重复，那服务器就会让其一个人开始

        if (ChessServer.readyUsers.contains(user.getUsername())) {
            System.out.println("已准备，不能再次准备");
            return;
        }

        //通过客户端传过来的user中的ready来判断，是否已经准备
        //做准备操作
        String username = user.getUsername();   //取出当前做准备的用户的姓名
        ChessServer.readyUsers.add(username);   //给服务器中正在准备等待游戏的人添加数量

        //再服务器端统计准备游戏的人数，当服务器端知道准备游戏的人数>=2
        //才去给两个客户端赋值红方和黑方，最后再把修改好了的user，返回给客户端
        //通过判断服务器中存储的准备阶段玩家的个数>=2，来判断是否可以开始游戏
        if (ChessServer.readyUsers.size() >= 2) {
            //可以开始游戏，要通知双方，所以要利用这双方的Socket
            //遍历准备阶段的玩家的集合
            String fangzhu = null;
            String nofangzhu = null;
            for (int i = 0; i < 2; i++) {
                //因为List是存储有序的，先存进来的就是先点击准备的
                if (i == 0) {   //这个就说明是第一个进来的
                    //第一个进来的人，默认为红方，这就是红方
                    user.setColor(1);
                } else {
                    //这就是黑方
                    user.setColor(2);
                }
                //拿到当前准备的用户的名称
                String str = ChessServer.readyUsers.poll();
                if (i == 0) {   //记录当前房主和对战玩家的姓名，下面存入服务器，哪两个玩家匹配了
                    fangzhu = str;
                } else {
                    nofangzhu = str;
                }
                //根据用户的名称获取当前客户端的Socket通过
                SocketChannel client = ChessServer.userSocketMap.get(str);
                user.setStatus(User.StatusEnum.READY);  //设置一下，让客户端去执行准备操作
                //服务器端构造准备消息，发送给客户端，
                //服务器修改了客户端发来的消息，然后再传给客户端
                NIOStream.writeMessage(client, user);
            }
            //当两个玩家都准备后,服务器记录，哪两个人匹配了
            ChessServer.match.put(fangzhu, nofangzhu);
            ChessServer.match.put(nofangzhu, fangzhu);
            //方便后面走棋查找对方
        } else {
            System.out.println("玩家数量不够，请继续等待");
        }
    }

    /**
     * 服务器端处理登录请求
     *
     * @param user 客户端传过来的对象
     */
    private void loginProcess(User user) {
        boolean checkLogin = false;
        String userName = user.getUsername();
        String password = user.getPassword();

        //创建检测对象，连接数据库中检测用户名和密码是否正确
        //数据库给username和password创建了组合索引，提高查找效率
        //只用连接一次数据库，建造了一个数据库连接池
        //第一个玩家登录去连接数据库，后面的，直接复用资源即可
        Check check = new Check(userName,password);
        checkLogin = check.check();

        //去文件检测，user用户的用户名和密码是否正确
        //checkLogin = checkLogin(userName, user.getPassword());

        if (checkLogin) {
            //服务器端检测到登录成功，立马通知客户端
            System.out.println("登陆成功，并通知客户端");
            //把该user的成功标志设置一下，最后返回
            user.setLoginSuccessFlag(true);
            //设置当前玩家的操作是进行登录操作
            user.setStatus(User.StatusEnum.LOGIN);
            //最后再把修改好的user再写给客户端
            NIOStream.writeMessage(socketChannel, user);

            /**
             * 每次登录成功一个客户端
             * 然后添加users(所有在线人数的姓名的集合)
             * 然后再在客户端的userSocketMap中添加姓名-》姓名对应的客户端通道
             */
            //记录此人的在线信息
            ChessServer.users.add(userName);
            //记录当前登录用户和与之对应的客户端通道
            ChessServer.userSocketMap.put(userName, socketChannel);
        } else {
            //服务器端检测到登录失败，通知客户端
            System.out.println("登录失败，并通知客户端");
            //当前客户端请求登录失败，给user的登录成功与否标记赋值为false
            user.setLoginSuccessFlag(false);
            //再给请求客户端登录的user的状态赋值为登录状态
            user.setStatus(User.StatusEnum.LOGIN);

            //最后再写回给客户端
            NIOStream.writeMessage(socketChannel, user);
        }

    }

    /**
     * 校验用户名和密码是否匹配
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否正确
     */
    private boolean checkLogin(String username, String password) {
        try {
            InputStream is = new FileInputStream(new File("src/main/java/user.txt"));
            DataInputStream dis = new DataInputStream(is);
            String line = null;
            while ((line = dis.readLine()) != null) {
                if (line.equals(username + "|" + password)) {
                    return true;
                }

            }
            dis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
