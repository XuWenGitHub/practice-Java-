package chess.board;


import chess.entity.User;
import chess.io.IOStream;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.net.Socket;

/**
 * @PackgeName: chess.board
 * @ClassName: ChatFrame
 * @Author: XuWen
 * Date: 2020/10/30 22:38
 * Introduce:
 */
public class ChatFrame extends JPanel {
    //JPanel的父类JComponent实现了序列化接口
    private static final long serialVersionUID = 3113538137993490299L;

    ChatFrame chatFrame = null;

    JTextPane txtsend = null;

    JTextPane txtacceput = null;

    Socket socket = null;

    String username = null;
    //接收框，表情图标，抖动图标,发送框，发送按钮
    public ChatFrame(Socket socket,String username){
        this.username = username;
        this.socket = socket;
        chatFrame = this;
        this.setLayout(null);
        this.setOpaque(false);  //设置透明

        //接收框
        txtacceput = new JTextPane();
        txtacceput.setOpaque(false);
        txtacceput.setSize(190,550);
        //因为接受框有时候消息太多需要滚动，就用JScrollPane添加滚动条
        JScrollPane scoPaneOne = new JScrollPane(txtacceput);
        scoPaneOne.setBounds((320-280)/2-5,20,200,332);
        scoPaneOne.setOpaque(false);    //透明度
        scoPaneOne.getViewport().setOpaque(false);  //设置透明度
        this.add(scoPaneOne);

        //发送框
        txtsend = new JTextPane();
        txtsend.setOpaque(false);
        txtsend.setSize(220,110);

        //因为发送框有时候发送消息太多需要滚动，就用JScrollPane添加滚动条
        JScrollPane scoPane = new JScrollPane(txtsend);
        scoPane.setBounds((320-280)/2-5,400,200,112);
        scoPane.setOpaque(false);    //透明度
        scoPane.getViewport().setOpaque(false);  //设置透明度
        this.add(scoPane);

        //添加表情选择
        JLabel lblface = new JLabel(new ImageIcon("images/face.png"));
        lblface.setBounds(14,363,25,25);
        this.add(lblface);
        //表情按钮添加点击事件
        lblface.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //提供表情窗体 JFrame
                FaceFrame faceFrame = new FaceFrame(txtsend);

            }
        });

        //添加抖动效果
        JLabel lbldoudong = new JLabel(new ImageIcon("images/doudong.png"));
        lbldoudong.setBounds(43,363,25,25);
        this.add(lbldoudong);
        //抖动按钮添加点击事件
        lbldoudong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //只需要窗体上下抖动即可,抖动需要开线程，否则会耽误主线程
                //客户端点击窗口抖动发送给服务器
                User user = new User();
                user.setUsername(username);
                user.setStatus(User.StatusEnum.DD);
                IOStream.writeMessage(socket,user);
//                DouDong douDong = new DouDong(chatFrame);
//                douDong.start();
            }
        });

    }
}
