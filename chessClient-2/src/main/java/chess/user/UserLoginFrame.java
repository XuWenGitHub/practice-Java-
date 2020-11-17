package chess.user;

import chess.board.ClientThread;
import chess.entity.User;
import chess.io.IOStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/26 10:17
 * Introduce:
 */
public class UserLoginFrame extends JFrame {
    /**
     * 登录窗体的宽度
     */
    private static final Integer FRAME_WIDTH = 400;
    /**
     * 登录窗体的高度
     */
    private static final Integer FRAME_HEIGHT = 300;

    public UserLoginFrame(){
        /**
         * 设置窗体
         */
        setSize(FRAME_WIDTH,FRAME_HEIGHT);  //设置登录界面的宽度和高度
        setTitle("用户登录");   //设置登录界面窗体的标签
        //得到屏幕的宽度和高度
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        //设置窗体的位置，设置在屏幕中间
        setLocation((width-FRAME_WIDTH)/2,(height-FRAME_WIDTH)/2);
        //设置窗体关闭，程序退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体布局为空
        setLayout(null);
        //设置窗体不可最大化
        setResizable(false);

        /**
         * 设置当前窗体的背景图片，就用一个标签来保存图片，占满窗体即可
         * 整体思路：窗体添加一个标签把窗体占满，然后其他的控件添加在background上面
         */
        //从指定文件路径加载登录窗体的背景图片
        ImageIcon imageIcon = new ImageIcon("images/login.jpg");
        //创建一个标签并将图片添加进去
        JLabel lblBackground = new JLabel(imageIcon);
        //设置图片的位置和大小，因为要设置成全覆盖，所以就是窗体的宽度和高度
        lblBackground.setBounds(0,0,FRAME_WIDTH,FRAME_HEIGHT);;
        //设置标签布局为空布局
        lblBackground.setLabelFor(null);
        //把标签添加到当前窗体中
        add(lblBackground);


        /**
         * 创建一个标签"账号"
         */
        JLabel username = new JLabel("账 号：");   //创建标签，叫账号
        //设置位置、大小
        username.setBounds(100,40,50,30);
        //设置标签文本的颜色为灰色
        username.setForeground(Color.WHITE);
        //将标签添加到背景图片上
        lblBackground.add(username);


        /**
         * 创建输入账号文本框,然后绑定事件监听事件
         */
        final JTextField usernameField = new JTextField();
        //设置文本框的位置、大小
        usernameField.setBounds(150,40,140,25);;
        lblBackground.add(usernameField);    //背景上面添加文本框
        //给密码框添加监听事件，添加键盘类型化监听事件
        //KeyListener是监听键盘输入，有三个方法（keyAdapter()是一个实现KeyListener接口的抽象类，这个当对象的话，只需要重写自己需要的方法
        //（1）keyTyped（keyEvent e）键盘类型化时调用（2）keyReleased（keyEvent e）键盘释放后执行事件
        //（3）keyPressed（keyEvent e）键盘按下执行事件 三个顺序一般是3->1->2
        // 当用户输入密码长度超过5个给出提示
        //提示账号长度最多5个,验证密码框中长度最多5个
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //暂停输入
                Object source = e.getSource();//事件最初发生的对象。
                if(source instanceof JTextField){   //检查类型
                    JTextField textField = (JTextField)source;
                    String text = textField.getText();  //获取用户名
                    if(text.length()>4){
                        e.consume();//只能在keyTyped中使用,当超过5个就不让输入
                        //当超过5个弹出一个窗口，提示用户账户个数不能超过5个
                        JOptionPane.showMessageDialog(null,"用户名长度不能超过5位");
                    }
                }
            }
        });

        /**
         * 创建一个标签"密码"
         */
        JLabel password = new JLabel("密 码：");
        //设置密码标签的位置、大小
        password.setBounds(100,80,50,30);
        //设置字体颜色为灰色
        password.setForeground(Color.WHITE);
        //添加到背景图片上
        lblBackground.add(password);


        /**
         * 创建一个密码框，用于用户输入密码，
         * 然后再密码框绑定事件，当个数>5个后，给出提示，最多5位
         */
        JPasswordField passwordField = new JPasswordField();
        //设置面框的位置、大小
        passwordField.setBounds(150,80,140,25);
        lblBackground.add(passwordField);   //把密码框添加到背景图片上
        //给密码框添加监听事件，添加键盘类型化监听事件
        //KeyListener是监听键盘输入，有三个方法（keyAdapter()是一个实现KeyListener接口的抽象类，这个当对象的话，只需要重写自己需要的方法
        //（1）keyTyped（keyEvent e）键盘类型化执行事件（2）keyReleased（keyEvent e）键盘释放后执行事件
        //（3）keyPressed（keyEvent e）键盘按下执行事件 三个顺序一般是3->1->2
        // 当用户输入密码长度超过5个给出提示
        //提示密码长度最多5个,验证密码框中长度最多5个
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {  //文本框格式监听，就是一输入就开始监听
                //暂停输入
                Object source = e.getSource();  //获取当前监听的对象，就是密码框对象
                if(source instanceof JPasswordField){
                    JPasswordField textPsw = (JPasswordField)source;
                    char[] password = textPsw.getPassword();
                    if(password!=null&&password.length>4){  //因为第一个监听器没有监听到
                        e.consume();//只能在KeyTyped中使用,当超过5个就不让输入
                        ////当超过5个弹出一个窗口，提示用户账户个数不能超过5个
                        JOptionPane.showMessageDialog(null,"密码长度不能超过5位");
                    }
                }
            }

        });


        /**
         * 创建一个登陆按钮
         */
        //加载图片
        ImageIcon iconEnter = new ImageIcon("images/denglu.jpg");
        //创建一个图片按钮
        JButton enter = new JButton(iconEnter);
        //设置登录按钮的位置和大小
        enter.setBounds(110,170,80,25);
        lblBackground.add(enter);   //给背景添加登录按钮
        //添加鼠标点击事件
        enter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = usernameField.getText();  //从账户文本框中获取输入账号
                char[] password = passwordField.getPassword();  //从密码文本框中获取密码
                String pwd = new String(password);
                System.out.println(username+"|"+String.valueOf(password));
                //连接服务器，验证账号和密码
                connectionServer(username,pwd);
            }
        });


        /**
         * 创建一个取消按钮
         * 如果点击取消，就清空输入账号和输入密码的地方
         */
        //加载图片
        ImageIcon iconCancel = new ImageIcon("images/quxiao.jpg");
        //创建一个取消按钮
        JButton cancel = new JButton(iconCancel);
        //设置按钮的位置和大小
        cancel.setBounds(215,170,80,25);
        //把按钮添加到背景图片上
        lblBackground.add(cancel);
        //添加鼠标点击事件
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //内容清空
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        //设置窗体可见
        setVisible(true);   //显示窗体
    }




    //点击登录后，连接服务器，验证用户名和密码是否正确
    private void connectionServer(String username,String password){
        //验证用户名和密码是否为空,如果为空，给出弹框提示用户，....为空
        if(username==null||"".equals(username)){
            //给出弹框提示用户，用户名为空
            JOptionPane.showMessageDialog(null,"用户名为空");
            return;
        }
        if(password==null||"".equals(password)){
            //给出弹框提示用户，密码为空
            JOptionPane.showMessageDialog(null,"密码为空");
            return;
        }


        //1连接服务器
        try{
            //TCP协议是传输层的协议，因为可靠
            //TCP客户端连接的套接字，三次握手，四次挥手封账在Socket对象里面了
            Socket socket = new Socket("127.0.0.1",8888);

            //给客户端的账号和密码进行封装成对象，发送
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            //加入消息类型
            user.setStatus(User.StatusEnum.LOGIN);
            //获取客户端对象的输出流
            //发送用户名和密码进行登录
            //两个不同的项目，想要进行信息传输，就要在两边都建立相同的对象
            //发送对象是用的JSONFAST序列化和反序列化
            IOStream.writeMessage(socket,user);



            //开辟一个线程去处理消息的读写,保持长连接，不占用主线程
            ClientThread clientThread = new ClientThread(socket,this);
            clientThread.start();
            //序列化异常：NotSerializableException
            //
            //1.要新开一个线程，持续等待服务器端写消息
            //2.服务器端也要新开一个线程，持续等待客户端的写消息
            //因为要进行持续通讯，所以需要长连接
        } catch (IOException e) {
            e.printStackTrace();
        }


        //因为现在没有写服务器，所以现在客户端校验
        //测试根据用户名和密码比对文件中用户名和密码是否匹配
//        if(checkLogin(username, password)){
//            JOptionPane.showMessageDialog(null,"登录成功");
//        }else {
//            JOptionPane.showMessageDialog(null,"登录失败");
//        }

    }




    /**
     * 因为现在没有写服务器，所以现在客户端校验
     * 校验用户名和密码是否匹配
     * @param username  用户名
     * @param password  密码
     * @return  是否正确
     */
    private boolean checkLogin(String username,String password){
        try {
            InputStream is = new FileInputStream(new File("src/user.txt"));
            DataInputStream dis = new DataInputStream(is);
            while (dis.readLine().equals(username+"|"+password)) {
                return true;
            }
            dis.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        UserLoginFrame d = new UserLoginFrame();
    }
}
