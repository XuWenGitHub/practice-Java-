package cn.itcast_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo2 {
    public static void main(String[] args) {
        //创建窗体
        Frame f = new Frame("有无蹦迪种子选手");
        //设置窗体属性和布局
        f.setBounds(400, 200, 500, 300);
        f.setLayout(new FlowLayout());
        //设置一个标签
        JLabel lb = new JLabel("有无蹦迪种子选手");
        f.add(lb);
        while (true) {
            //设置颜色
            f.setBackground(Color.RED);
            //显示窗口
            f.setVisible(true);
            f.setBackground(Color.YELLOW);
            //显示窗口
            f.setVisible(true);
            f.setBackground(Color.BLUE);
            //显示窗口
            f.setVisible(true);
            f.setBackground(Color.GREEN);
            //显示窗口
            f.setVisible(true);
            f.setBackground(Color.ORANGE);
            //显示窗口
            f.setVisible(true);
            f.setBackground(Color.WHITE);
            //显示窗口
            f.setVisible(true);


        //设置关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //显示窗口
        f.setVisible(true);

        }
    }
}
