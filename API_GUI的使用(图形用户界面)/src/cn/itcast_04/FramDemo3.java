package cn.itcast_04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FramDemo3 {
    public static void main(String[] args) {
        //创建窗体，设置窗体属性和布局
        Frame f = new Frame("获取QQ号");
        f.setBounds(400,200,500,300);
        f.setLayout(new FlowLayout());
        //创建标签
        JLabel jl = new JLabel("只能输入数字，不信你试试");
        //创建文本框
        TextField tf = new TextField(40);
        f.add(jl);
        f.add(tf);
        //设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //给文本框添加事件
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获取文本框的值
                char ch = e.getKeyChar();
                if(!(ch>='0'&&ch<='9')){
                    e.consume();
                }
            }
        });

        f.setVisible(true);
    }
}
