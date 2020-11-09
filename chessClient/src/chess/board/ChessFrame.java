package chess.board;

import chess.entity.ChessPoint;
import chess.entity.ChessRecord;
import chess.entity.FontStyle;
import chess.entity.User;
import chess.handler.ChessHanlder;
import chess.io.IOStream;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @PackgeName: chessClient.board
 * @ClassName: ChessFrame
 * @Author: XuWen
 * Date: 2020/10/26 21:25
 * Introduce:
 */
public class ChessFrame extends JFrame {
    /**
     * 窗体的宽度
     */
    private static final Integer FRAME_WIDTH=1000;

    /**
     * 窗体的高度
     */
    private static final Integer FRAME_HEIGHT=700;

    //定义一个JLabel的数组
    //这个就是棋盘的位置，有10行和9列，第一行从最上面开始
    //下棋的核心，记录棋盘每一个位置上的JLabel
    JLabel [][] lblChessArr = new JLabel[10][9];

    //默认设置不动
    Boolean move = false;

    //用于判断玩家是第一次点击还是第二次点击
    //记录第一个点击的棋子
    ChessPoint startPoint=null;
    //记录第二个点击的棋子
    ChessPoint endPoint=null;


    //定义一个数组，存放两个玩家的图片的JLabel
    JLabel[] playerChess = new JLabel[2];

    String userName;    //客户端的用户名

    Socket socket;  //客户端

    JButton prepareBtn; //棋盘的准备按钮

    JButton startBtn;   //棋盘的开始按钮

    JButton regretBtn;  //棋盘的悔棋按钮

    //赢棋
    Integer win = 0;

    //记录每一步走棋的记录,用栈，先进后出，用于悔棋
    Deque<ChessRecord> stack = new LinkedList<>();

    ChatFrame chatFrame = null;

    ChessFrame chessFrame = null;

    ShanDong shanDong = null;

    Icon startIcon = null;  //第二次点击验证后，

    public void setChessFrame(ChessFrame chessFrame){
        this.chessFrame = chessFrame;
    }

    public ChessFrame(Socket socket,String userName){
        this.socket = socket;
        this.userName = userName;


        /**
         * 初始化窗体
         */
        //设置标题
        this.setTitle("中国象棋");
        //设置窗体布局为空
        this.setLayout(null);
        //设置窗体不可最大化
        this.setResizable(false);
        //得到当前电脑的宽度
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        //得到当前电脑的高度
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        //设置窗体的位置和大小
        this.setBounds((width-FRAME_WIDTH)/2,(height-FRAME_HEIGHT)/2,FRAME_WIDTH,FRAME_HEIGHT);



        /**
         * 设置背景图片,将图片放入标签，再加入窗体
         */
        //加载图片
        ImageIcon imgBackground = new ImageIcon("images/cchess/bg.jpg");
        //创造标签加入标签
        JLabel lblBackground = new JLabel(imgBackground);
        //设置背景标签的位置和大小
        lblBackground.setBounds(0,0,FRAME_WIDTH,FRAME_HEIGHT);
        //把背景加入窗体
        this.add(lblBackground);


        /**
         * 添加棋盘
         */
        //加载图片
        ImageIcon chessBg = new ImageIcon("images/cchess/CChessOne.jpg");
        //创建标签，把图片放进去
        JLabel lblChessBoard = new JLabel(chessBg);
        //设置棋盘的大小位置
        lblChessBoard.setBounds(200, 30, 521, 557);
        //把棋盘添加到背景上面
        lblBackground.add(lblChessBoard);


        //用户准备的图片
        /**
         * 设置2个玩家的图片，但先不显示图片
         */
        for(int i=0;i<2;i++){
            //创建JLabel
            JLabel player = new JLabel();
            //设置玩家图片的位置和大小
            player.setBounds(10,110+i*200,122,165);
            lblBackground.add(player);
            //目前，先记录JLabel，不做图片的摆放，待两方准备完成的时候，再摆放
            playerChess[i]=player;  //一个数组存放图片
            //刷新界面
            lblBackground.updateUI();
        }


        /**
         * 在棋盘上面添加棋子,在棋盘上每一个位置都要有一个JLabel
         */
        //棋子添加到棋盘中，通过一个静态二维数组记录每个棋子的位置
        for(int row=0;row<10;row++){  //外层循环控制行
            for(int col=0;col<9;col++){ //外层循环控制列
                //制作一个类似于棋盘棋子排放的二维数组startChess,记录每个棋子，直接读取每个棋子位置,在下面
//                String chessName = startChess[row][col];    //存二维数组中取出棋子名字
//                if(chessName!=null&&!"".equals(chessName)){
//                    //如果棋子不是空，才会拼接路径，如果是空，不拼接路径，便于后面棋子点击判断是否点的是空
//                    chessName = "images/cchess/"+chessName+".png";
//                }

                //界面初始化时，棋子的图片可以没有，但是JLabel占的位置要有
                //因为要点击开始后才摆棋子，这里就不能摆好
                String chessName = "";

                //走到这里chessName如果在二维数组中不是空的话，才会拼接路劲
                //如果chessName在二维数组中是空，那么存储的Icon就是""

                //实例化了90个JLabel对象,每个对象都是可以放棋子
                ImageIcon cheIcon = new ImageIcon(chessName);    //加载棋子图片
                //创建每个棋子chess
                JLabel chess = new JLabel(cheIcon); //构建棋子标签
                chess.setBounds(20 + col * 54, 20 + row * 52 ,57, 57);  //设置每个棋子的位置和大小
                lblChessBoard.add(chess);   //棋盘上添加棋子

                //用lblChessArr数组记录90个JLabel对象!!!!
                lblChessArr[row][col] = chess;

                //给每个棋子添加鼠标点击监听事件
                chess.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {    //给每个棋子添加点击的事件绑定
                        if(!move||win>0){
                            //说明不能够走动
                            return;
                        }

                        Object source = e.getSource();  //获取点击的事件源
                        if(source instanceof JLabel){
                            //如何确定这个JLabel的位置
                            //就是通过一个双层循环，遍历lblChessArr记录90个JLabel对象，直到找到位置，
                            //然后返回ChessPoint对象,就是保存当前ChessPoint的图片和位置
                            JLabel chessTemp = (JLabel)source;  //当前鼠标点击的JLabel
                            //获取当前点击这个JLabel（chessTemp）的位置
                            ChessPoint chessPoint = getChessPoint(chessTemp);

                            //走动这个棋子
                            //把第一次点击的JLabel清空，第二次点击的JLabel变成上一次点击的JLabel图片
                            if(startPoint==null){   //说明就是鼠标第一次点击
                                //第一次拿字一定要拿到图片，不然空白JLabel就会覆盖棋子
                                String iconStr = chessTemp.getIcon().toString();
                                if(iconStr==null||"".equals(iconStr)){
                                    //如果第一次点到空，不算，不保存信息，不然先点击空再点击棋子空会覆盖棋子
                                    return;
                                }
                                //第一次点击，将当前点击的棋子记录在startPoint中
                                startPoint = chessPoint;    //给startPoint赋值为chessPoint

                                //再开启一个线程，让第一次鼠标点击的棋子，闪动，就是图片一下出来一下消失
                                startIcon = startPoint.getIcon();
                                shanDong = new ShanDong(chessFrame,startPoint);
                                shanDong.start();
                                //System.out.println("拿棋子"+chessPoint);
                            }else if(endPoint==null){   //说明就是鼠标第二次点击


                                //第二次落子之前，要进行规则校验
                                //根据每个棋子对象去校验规则,总共7个对象，所以需要7个规则来限定
                                //这里就可以用到工厂化设计模式，来一个抽象类，
                                // 提供一个静态方法，根据第一次点击的名字取出相对应的实例化对象
                                //再根据该实例化对象去调用validate方法去校验第二步走棋是否符合当前棋子的负责
                                boolean flag = false;   //标记是否满足规则
                                String chessIconStr = startPoint.getIcon().toString();  //取出第一次点击的JLabel的名字


                                //根据第一次点击的JLabel的名字，去获得该棋子的实例化对象
                                ChessHanlder chessHanlder = ChessHanlder.getInstance(chessIconStr);
                                //再调用该棋子的实例化对象的validate方法，校验第二步棋子走的是否符合该棋子的规则
                                flag = chessHanlder.validate(startPoint,chessPoint,lblChessArr);
                                //上面方法用的chessPoint，因为成员变量endPoint还没有赋值，要先判断是否满足规则，然后再赋值
                                //不然直接赋值的化，如果不满足任意一点规则，又要把endPoint清空，这样就很麻烦，所以先不赋值
                                //chessPoint，就是第二次点击的棋子
                                //lblChessArr这个是一个二维数组保存所有的棋子，传进去，判断棋子走动是否别脚

                                if(flag) {  //校验棋子的规则，如果走动的符合规则，才能走动
                                    endPoint = chessPoint;
                                    //让主线程等到闪动线程结束
                                    try {
                                        shanDong.join();
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                    lblChessArr[startPoint.getRow()][startPoint.getCol()].setIcon(startIcon);
//

                                    //走到这里是校验规则合法，那么我们就需要给服务器发送消息，通知服务器下棋
                                    User user = new User();
                                    user.setStatus(User.StatusEnum.RUN);
                                    //因为Icon这个不支持传输
                                    //封装起点的对象
                                    startPoint.setIconName(startPoint.getIcon().toString());
                                    startPoint.setIcon(null);
                                    //把第一次点击的棋子和第二次点击的棋子传给服务器
                                    user.setStartPoint(startPoint);
                                    //封装落子点的对象
                                    chessPoint.setIconName(chessPoint.getIcon().toString());
                                    chessPoint.setIcon(null);
                                    user.setEndPoint(chessPoint);

                                    user.setUsername(userName); //把用户名给过去，服务器通过用户名判断是谁在下棋
                                    user.setStatus(User.StatusEnum.RUN);
                                    //判断输赢
                                    if(chessPoint.getIconName().contains("将1")){
                                        //红方赢
                                        user.setWin(1);
                                    }else if(chessPoint.getIconName().contains("将2")){
                                        //黑方赢
                                        user.setWin(2);
                                    }
                                    IOStream.writeMessage(socket,user); //给服务器发消息下棋

                                    //走棋操作
//                                    endPoint = chessPoint;  //第二次点击的棋子
//                                    //不能点击两次同一个棋子,这个是由每个棋子规则去控制，目前先不管
//
//                                    //第二次点击,把第二次点击位置的JLabel中的Icon(图片)变成第一次点击位置的JLabel中的Icon(图片)
//                                    //把第二次点击位置的JLabel中的Icon(图片)变成第一次点击位置的JLabel中的Icon(图片)
//                                    chessTemp.setIcon(startPoint.getIcon());
//
//                                    //再把第一次点击位置的JLabel图像清空
//                                    //setIcon是要一个Icon的对象，但是Icon是个接口，就要其实现类的对象
//                                    //ImageIcon就是Icon的实现类
//                                    JLabel startChess = lblChessArr[startPoint.getRow()][startPoint.getCol()];
//                                    startChess.setIcon(new ImageIcon(""));
//
//                                    //第二次点击，棋子每移动后,要将startPoint和endPoint置空
//                                    //不然就能移动一次!!!
//                                    startPoint = null;
//                                    endPoint = null;
                                }
                            }
                        }
                    }
                });



            }
        }

        /**
         * 准备三个按钮，分别对应，准备，开始，悔棋
         */
        /**
         * 准备按钮
         */
        prepareBtn = new JButton(new ImageIcon("images/anniu/zhunbei.jpg"));
        prepareBtn.setBounds(220,610,90,29);
        //prepareBtn.setBackground(Color.white);
        lblBackground.add(prepareBtn);
        prepareBtn.setEnabled(true);
        //现在给准备按钮添加点击事件
        prepareBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //需要准备给服务器的发送数据,给服务器发消息
                User user = new User();
                //把当前的用户名给记住，后续就根据用户名来确认，谁是红方，谁是黑方
                user.setUsername(userName);
                user.setReady(1);   //设置当前用户准备属性已准备，1代表准备,0代表还没有准备
                user.setStatus(User.StatusEnum.READY);  //设置当前用户正在进行准备阶段



                //通知服务器，有一个客户端已经准备好了，然后通知服务器
                //向服务器申请准备
                IOStream.writeMessage(socket,user);

            }
        });


        /**
         * 开始按钮
         */
        startBtn = new JButton(new ImageIcon("images/anniu/kaishi.jpg"));
        startBtn.setBounds(610,610,90,29);
        lblBackground.add(startBtn);
        //禁用开始按钮，等两个都连接后，再放开
        startBtn.setEnabled(false); //设置开始按钮为灰色，按不动，要两个玩家都准备，才可以按

        //现在给开始按钮绑定事件
        startBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //向服务器发送消息
                //至于谁能够点击开始按钮，再客户端收到服务器发来的准备消息的时候，就已经被激活了
                //只有房主，也就是第一个进来的，才能点击该按钮
                User user = new User();
                user.setStatus(User.StatusEnum.START);
                user.setUsername(userName);
                //能够点击开始按钮的是红方
                user.setColor(1);
                //向服务器发送消息
                IOStream.writeMessage(socket,user);

            }
        });

        /**
         * 悔棋按钮
         */
        regretBtn = new JButton(new ImageIcon("images/anniu/huiqi.jpg"));
        regretBtn.setBounds(420,610,90,29);
        lblBackground.add(regretBtn);
        //禁用悔棋按钮，等两个都连接后，再放开
        regretBtn.setEnabled(false);    //先禁用悔棋按钮
        //给悔棋按钮，添加点击事件
        regretBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //确认已经走过棋，我们才能够悔棋
                int size = stack.size();
                if(size>0) {
                    User user = new User();
                    user.setStatus(User.StatusEnum.HQSQ);
                    user.setUsername(userName);
                    IOStream.writeMessage(socket, user);
                }
            }
        });

        /**
         * 添加聊天组件
         */
        //加入聊天的组件，接收框，表情图标，抖动图标,发送框，发送按钮
        //把它们作为一体加入,JPanel组件
        chatFrame = new ChatFrame(this.socket);
        //设置聊天窗体的位置大小
        chatFrame.setBounds(770,50,230,528);
        //添加背景
        lblBackground.add(chatFrame);

        /**
         * 添加发送按钮
         */
        //添加发送按钮
        JButton sendBtn = new JButton(new ImageIcon("images/anniu/fasong.jpg"));
        sendBtn.setBounds(840,610,90,29);
        lblBackground.add(sendBtn);
        sendBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //得到待发送的内容
                List<FontStyle> fonts = FontSupport.footEncode(chatFrame.txtsend);
                User user = new User();
                user.setStatus(User.StatusEnum.CHAT);
                user.setUsername(userName);
                user.setFonts(fonts);
                IOStream.writeMessage(socket,user);
//                //将内容追加到接收框
//                FontSupport.footDecode(chatFrame.txtacceput,fonts,userName);

                //将发送框的内容清除
                chatFrame.txtsend.setText("");



            }
        });

        //设置窗体关闭，程序退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体可见
        this.setVisible(true);
    }


    /**
     * 找到chessTemp棋子在二维数组的位置
     * @param chessTemp 寻找的棋子
     * @return  返回int[]  arr[0]为该棋子的行  arr[1]为该棋子的列
     */
    private ChessPoint getChessPoint(JLabel chessTemp){
        //代表找到该棋子的行和列，记录行和列
        ChessPoint pointTemp = new ChessPoint();    //实例化一个棋子
        for (int row = 0; row <lblChessArr.length; row++){
            for(int col = 0;col<lblChessArr[row].length;col++){
                if(lblChessArr[row][col]==chessTemp){
                    pointTemp.setRow(row);  //chessTemp棋子在棋盘的行位置添加
                    pointTemp.setCol(col);  //chessTemp棋子在棋盘的列位置添加

                    //把当前棋子的图片也添加到pointTemp的Icon
                    pointTemp.setIcon(chessTemp.getIcon());
                    return pointTemp;
                }
            }
        }
        return pointTemp;
    }


    //定义一个静态的成员变量，用于初始化棋子
    public static String[][] startChess = {
            // 定义一个二维数组
            { "车1", "马1", "相1", "士1", "将1", "士1", "相1", "马1", "车1" },
            { "", "", "", "", "", "", "", "", "" },
            { "", "炮1", "", "", "", "", "", "炮1", "" },
            { "卒1", "", "卒1", "", "卒1", "", "卒1", "", "卒1" },
            { "", "", "", "", "", "", "", "", "" },
            { "", "", "", "", "", "", "", "", "" },
            { "卒2", "", "卒2", "", "卒2", "", "卒2", "", "卒2" },
            { "", "炮2", "", "", "", "", "", "炮2", "" },
            { "", "", "", "", "", "", "", "", "" },
            { "车2", "马2", "相2", "士2", "将2", "士2", "相2", "马2", "车2" }
    };


//    //测试一下棋盘
//    public static void main(String[] args) {
//        ChessFrame cf = new ChessFrame();
//    }
}
