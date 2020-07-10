package cn.itcast_05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/*
* 多级菜单
* */
public class FramDemo2 {
    public static void main(String[] args) {
        //创建窗体设置其属性
        final JFrame jf = new JFrame("多级菜单");
        jf.setBounds(400,200,500,300);
        jf.setLayout(new FlowLayout());
        final String name = jf.getName();
        //创建菜单栏
        JMenuBar jmb = new JMenuBar();
        //创建菜单
        JMenu jm = new JMenu("文件");
        JMenu jm1 = new JMenu("更改名称");
        //创建菜单项
        JMenuItem jm2 = new JMenuItem("打开记事本");
        JMenuItem jm3 = new JMenuItem("退出系统");

        JMenuItem jmi1 = new JMenuItem("好好学习");
        JMenuItem jmi2 = new JMenuItem("天天向上");
        JMenuItem jmi3 = new JMenuItem("恢复标题");

        jm1.add(jmi1);
        jm1.add(jmi2);
        jm1.add(jmi3);
        jm.add(jm1);
        jm.add(jm2);
        jm.add(jm3);
        jmb.add(jm);
        jf.setJMenuBar(jmb);

        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.setTitle("好好学习");
            }
        });
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.setTitle("天天向上");
            }
        });
        jmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jf.setTitle(name);
            }
        });
        jm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Runtime r = Runtime.getRuntime();
                try {
                    r.exec("notepad");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        jm3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        //设置窗体关闭
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });



        //窗口可见
        jf.setVisible(true);
    }
}
