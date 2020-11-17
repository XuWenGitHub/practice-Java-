package chess.board;

import chess.entity.ChessPoint;
import chess.entity.ChessRecord;
import chess.entity.FontStyle;
import chess.entity.User;
import chess.io.IOStream;
import chess.user.UserLoginFrame;

import javax.swing.*;
import java.net.Socket;
import java.util.Deque;
import java.util.List;

/**
 * @PackgeName: chessClient.board
 * @ClassName: CilentThread
 * @Author: XuWen
 * Date: 2020/10/28 10:56
 * Introduce:客户端线程，处理服务器端写过来的消息,用于读取服务器发过来的消息,做出相应的操作
 */
public class ClientThread extends Thread {
    //当前客户端对象
    Socket socket = null;

    //登录界面窗体
    UserLoginFrame loginFrame = null;

    //客户端对象的姓名
    String userName;

    //棋盘对象
    ChessFrame chessFrame;

    public ClientThread(Socket socket, UserLoginFrame loginFrame){
        this.socket = socket;
        this.loginFrame = loginFrame;
    }

    @Override
    public void run() {

        while (true) {
            //这一行一直等到服务器发过来的消息，会产生阻塞
            // 这也会造成阻塞,把主线程给阻塞了
            //这里是接受徐文发送给我的消息的接受
            Object obj = IOStream.readMessage(socket);
            if(obj instanceof User){
                //通过读取到的obj类型如果是User，那么就是想要执行操作
                //然后我们强转obj为User，再获得user中StatusEnum值
                //StatusEnum是一个枚举类型，然后判断这个枚举类型是要执行什么操作
                User user = (User)obj;
                User.StatusEnum status = user.getStatus();

                if(status == User.StatusEnum.LOGIN){   //这是处理登录
                    //这是处理登录的
                    loginResult(user);  //读取服务器传过来的登录对象，中的标记，判断是否登录成功
                }else if(status== User.StatusEnum.READY){   //这是处理准备操作
                    //处理准备
                    readyResult(user);
                }else if(status == User.StatusEnum.START){
                    //开始游戏
                    startResult(user);
                }else if(status==User.StatusEnum.RUN){
                    //走棋操作
                    runResult(user);
                }else if(status ==User.StatusEnum.HQSQ){
                    //悔棋申请的操作
                    hqsqResult(user);
                }else if(status ==User.StatusEnum.REJECT){
                    //不同意悔棋的操作
                    rejectResult(user);
                }else if(status==User.StatusEnum.AGREE){
                    //同意悔棋操作
                    agreeHqResult(user);
                }else if(status==User.StatusEnum.CHAT){
                    //聊天消息接收
                    chatMsgResult(user);
                }else if(status==User.StatusEnum.DD){
                    //窗口抖动
                    ddResult(user);
                }


            }
            System.out.println("客户端接受到消息：" + obj);
        }

    }

    /**
     * 窗口抖动
     * @param user  服务器传来的对象
     */
    private void ddResult(User user){
        DouDong douDong = new DouDong(chessFrame.chatFrame);
        douDong.start();
    }

    /**
     * 聊天消息接收
     * @param user  服务器发来的消息
     */
    private void chatMsgResult(User user){
        if(!user.isMatch()){
            //弹出框框显示未匹配，不能发送消息
            JOptionPane.showMessageDialog(null, "未匹配到对手");
            return;
        }
        List<FontStyle> fonts = user.getFonts();
        String username = user.getUsername();
        FontSupport.footDecode(chessFrame.chatFrame.txtacceput,fonts,username);
    }

    /**
     * 同意悔棋操作
     * @param user  服务器发来的消息,根据是否能动，来判断，谁悔的棋
     */
    private void agreeHqResult(User user){
        //把棋盘中每次存储下棋步骤的栈拿到
        Deque<ChessRecord> chessRecords = chessFrame.stack;
        //将最新的一条记录取出，会删除这条记录
        ChessRecord peek = chessRecords.pop();
        ChessPoint startPoint = peek.getStartPoint();
        ChessPoint endPoint = peek.getEndPoint();

        //悔棋就跟下棋操作反着走即可
        JLabel endLabel = chessFrame.lblChessArr[endPoint.getRow()][endPoint.getCol()];
        endLabel.setIcon(new ImageIcon(endPoint.getIconName()));
        //endLabel.setIcon(new ImageIcon(""));

        //设置起始点的位置图片为落子点的图片
        JLabel startLabel = chessFrame.lblChessArr[startPoint.getRow()][startPoint.getCol()];
        //因为最后棋盘中startPoint有值，但是endPoint被设置为null了
//        System.out.println(startPoint.getIconName());
//        System.out.println(endPoint.getIconName());
        startLabel.setIcon(new ImageIcon(startPoint.getIconName()));
        //startLabel.setIcon(new ImageIcon(startPoint.getIconName()));


        //因为同意悔棋，悔棋成功的那个将继续下棋
        Boolean moveFlag = user.getMoveFlag();
        chessFrame.move = moveFlag;
    }

    /**
     * 不同意悔棋操作
     * @param user  服务器传来的消息
     */
    private void rejectResult(User user){

        JOptionPane.showMessageDialog(null,"对方不同意悔棋，请继续下棋");
    }

    /**
     * 悔棋申请操作
     * @param user  服务器传给客户端的消息
     */
    private void hqsqResult(User user){
        int value = JOptionPane.showConfirmDialog(null,"对方想悔棋","悔棋",JOptionPane.YES_NO_OPTION);
        if(value==JOptionPane.YES_OPTION){
            //同意悔棋
            user.setStatus(User.StatusEnum.AGREE);
        }else{
            //不同意悔棋
            user.setStatus(User.StatusEnum.REJECT);
        }
        user.setUsername(userName);
        IOStream.writeMessage(socket,user);
    }

    /**
     * 走棋操作
     * @param user 服务器传来的消息
     */
    private void runResult(User user){
        ChessPoint startPoint = user.getStartPoint();
        ChessPoint endPoint = user.getEndPoint();
        //通过这个判断谁是下棋方
        //不能动的是下期方
        Boolean moveFlag = user.getMoveFlag();


        int endRow = endPoint.getRow();
        int endCol = endPoint.getCol();
        int startRow = startPoint.getRow();
        int startCol = startPoint.getCol();

        //因为下棋方和下期方对方棋盘不一样，所有设置临时遍历
//        int tempEndRow = 0; //第二次点击的行
//        int tempEndCol = 0; //第二次点击的列
//        int tempStartRow = 0;   //第一次点击的行
//        int tempStartCol = 0;   //第一次点击的列
        if(!moveFlag){   //下棋方，正常走
//            tempEndRow = endRow;
//            tempEndCol = endCol;
//            tempStartRow = startRow;
//            tempStartCol = startCol;
        }else{  //下期方对方
//            tempEndRow = 9-endRow;
            endPoint.setRow(9-endRow);
//            tempEndCol = 8-endCol;
            endPoint.setCol(8-endCol);
//            tempStartRow = 9-startRow;
            startPoint.setRow(9-startRow);
//            tempStartCol = 8-startCol;
            startPoint.setCol(8-startCol);

        }
        //记录每一步下棋的操作,这里的操作已经计算后了，张三和李四不一样
        ChessRecord chessRecord = new ChessRecord();
        chessRecord.setEndPoint(endPoint);
        chessRecord.setStartPoint(startPoint);
        chessFrame.stack.push(chessRecord);

        //根据落点的棋子数据对象，获取整个棋盘中该棋子所在的位置对象JLabel
        JLabel endLabel = chessFrame.lblChessArr[endPoint.getRow()][endPoint.getCol()];
        //不能点击两次同一个棋子,这个是由每个棋子规则去控制，目前先不管
        //第二次点击,把第二次点击位置的JLabel中的Icon(图片)变成第一次点击位置的JLabel中的Icon(图片)
        //把第二次点击位置的JLabel中的Icon(图片)变成第一次点击位置的JLabel中的Icon(图片)
        //设置点的位置的图片为第一次点击的位置的图像
        endLabel.setIcon(new ImageIcon(startPoint.getIconName()));

        //再把第一次点击位置的JLabel图像清空
        //setIcon是要一个Icon的对象，但是Icon是个接口，就要其实现类的对象
        //ImageIcon就是Icon的实现类
        //设置起始点位置的图像为空
        JLabel startChess = chessFrame.lblChessArr[startPoint.getRow()][startPoint.getCol()];
        startChess.setIcon(new ImageIcon(""));

        Integer win = user.getWin();
        if(win!=null){
            if(win==1){
                //红方赢，清空棋盘
                JOptionPane.showMessageDialog(null,"红方胜利");
                chessFrame.win = 1;
            }else {
                //黑方赢，清空棋盘
                JOptionPane.showMessageDialog(null,"黑方胜利");
                chessFrame.win = 2;
            }
        }

        //第二次点击，棋子每移动后,要将startPoint和endPoint置空
        //不然就能移动一次!!!
        //将上一次走棋的记录置为空，下一次才可以正常走棋
        chessFrame.startPoint = null;
        chessFrame.endPoint = null;

        //重置能否下棋的状态
        chessFrame.move = moveFlag;
    }

    /**
     * 开始操作
     * @param user  服务器传来的消息
     */
    private void startResult(User user){
        Integer color = user.getColor();
        Boolean moveFlag = user.getMoveFlag();
        chessFrame.move = moveFlag; //给客户端能动不能动
        //摆棋操作
        for(int row=0;row<10;row++) {  //外层循环控制行
            for (int col = 0; col < 9; col++) { //外层循环控制列
                String chessName = ChessFrame.startChess[row][col];    //存二维数组中取出棋子名字
                if(chessName!=null&&!"".equals(chessName)){
                    //如果棋子不是空，才会拼接路径，如果是空，不拼接路径，便于后面棋子点击判断是否点的是空
                    chessName = "images/cchess/"+chessName+".png";
                }
                //取出已经站好位置的JLabel
                JLabel[][] lblChessArr = chessFrame.lblChessArr;
                if(color==1){
                    //红方,正常摆棋,可以走动
                    lblChessArr[row][col].setIcon(new ImageIcon(chessName));

                }else{
                    //黑方，反着摆棋，不可以走动
                    lblChessArr[9-row][8-col].setIcon(new ImageIcon(chessName));

                }
            }
        }
        //点击开始后，就把两个客户端的悔棋按钮放开
        chessFrame.regretBtn.setEnabled(true);
        //点击开始后，也把两个客户端的开始按钮关闭
        chessFrame.startBtn.setEnabled(false);
    }

    /**
     * 服务器给客户端传来准备操作
     * 服务器判断等待人数>=2的时候，
     * 才会给客户端发送准备的消息
     * 准备操作,准备图片显示
     * @param user  服务器传过来的
     */
    private void readyResult(User user){
        //加载头像和关闭两个客户端的准备按钮，开启红方的开始按钮

        //需要控制，chessFrame界面，显示对应的图标
        //playerChess是两个玩家头像的JLabel
        JLabel[] playerChess = chessFrame.playerChess;
        //给不同的客户端进行图片显示
        //不同的客户端都会进入一遍这里面
        for(int i=0;i<playerChess.length;i++){
            //如果我方先开始，那采用nvz，否则采用nanz
            //张三和李四客户端都会接受到通知，并且进入这段代码
            if(user.getColor()==1){ //代表红方
                //红方启动开始按钮
                //这里有bug，都准备了，但是一方都没有显示开始按钮
                //已经修复
                chessFrame.startBtn.setEnabled(true);
                //给红方的棋盘头像，第一个位置设置成女，第二个位置设置成男
                playerChess[i].setIcon(new ImageIcon("images/iconimg/"+player[i]+".png"));

            }else { //代表黑方
                //给黑方的棋盘上的头像，第一个位置设置成男，第二个位置设置成女
                playerChess[i].setIcon(new ImageIcon("images/iconimg/"+player[1-i]+".png"));

            }
            //nvz  nanz 这是两个头像的jpg名字
            //客户端都去禁用准备按钮，
            //因为这里是读取服务器让客户端进入准备状态，已经有两个客户端都准备过了，所以禁用客户端的准备按钮
            //这里有bug，都准备了，都设置成false了，但是都显示准备按钮
            //已经修复
        }
        chessFrame.prepareBtn.setEnabled(false);
    }
    String[] player = new String[]{"nvz","nanz"};

    /**
     * 登录功能
     * @param user   服务器传过来的
     */
    //根据从客户端中读取到的对象obj转成user，中的loginSuccessFlag来判断
    //服务器那边验证账号和密码是否正确
    private void loginResult(User user){
        System.out.println(user);
        //拿出服务器传来的对象中的登录是否成功标记，来判断登录是否成功
        Boolean loginSuccessFlag = user.getLoginSuccessFlag();
        if (loginSuccessFlag) {
            userName = user.getUsername();
            //弹出框框显示登录成功
            JOptionPane.showMessageDialog(null, "登录成功");
            //唤醒棋盘
            chessFrame = new ChessFrame(socket,userName);
            chessFrame.setChessFrame(chessFrame);
            //关闭当前窗体
            loginFrame.dispose();   //登录的窗体
        } else {
            JOptionPane.showMessageDialog(null, "登录失败");
        }

    }
}
