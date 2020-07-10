package cn.itcast_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameDemo {
    public static void main(String[] args) {
        //创建窗体对象
        Frame f = new Frame();
        //给窗体设置属性和布局
        f.setBounds(400,200,500,300);
        f.setLayout(new FlowLayout());

        //设置按钮
        JButton redJButtom = new JButton("红色");
        JButton greenJButtom = new JButton("绿色");
        JButton blueJButtom = new JButton("蓝色");

        //把组件添加到窗体
        f.add(redJButtom);
        f.add(greenJButtom);
        f.add(blueJButtom);

        //对按钮添加动作事件
//        redJB.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                f.setBackground(Color.RED);
//            }
//        });
        //对按钮添加鼠标事件
        redJButtom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                f.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                f.setBackground(Color.WHITE);
            }
        });
        greenJButtom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                f.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                f.setBackground(Color.WHITE);
            }
        });
        blueJButtom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                f.setBackground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                f.setBackground(Color.WHITE);
            }
        });
        //设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //显示窗体
        f.setVisible(true);
    }
}
