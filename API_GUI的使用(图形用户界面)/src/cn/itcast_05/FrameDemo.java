package cn.itcast_05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
* 一级菜单
* */
public class FrameDemo {
    public static void main(String[] args) {
        //创建窗体对象并设置属性
        JFrame f = new JFrame("一级菜单");
        f.setBounds(400,200,500,300);
        f.setLayout(new FlowLayout());

        //创建菜单栏
        JMenuBar mb = new JMenuBar();
        //创建菜单
        JMenu m = new JMenu("文件");
        //创建菜单项
        JMenuItem mi = new JMenuItem("退出系统");

        //添加
        m.add(mi);
        mb.add(m);
        f.setJMenuBar(mb);

        //设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //对菜单项添加事件
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        //设置窗体可见
        f.setVisible(true);
    }
}
