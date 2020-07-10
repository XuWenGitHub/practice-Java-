package cn.itcast_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
    public static void main(String[] args) {
        //创建窗体对象
        Frame f = new Frame("数据转移");
        //设置窗体属性和布局
        f.setBounds(400,200,500,300);
        f.setLayout(new FlowLayout());

        //创建文本框
        TextField tf = new TextField(20);
        //创建按钮
        JButton bu = new JButton("数据转换");
        //创建文本域
        TextArea ta = new TextArea(10,40);

        //把组件添加到窗体
        f.add(tf);
        f.add(bu);
        f.add(ta);

        //设置窗体关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //对按钮添加事件
        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //获取文本框的值
                String tf_str = tf.getText().trim();
                //清空数据
                tf.setText("");

                //设置给文本域
                //ta.setText(tf_str);   这个是替换文本域的值
                //追加加换行
                ta.append(tf_str+"\r\n");

                //获取光标
                tf.requestFocus();
            }
        });

        //设置窗体显示
        f.setVisible(true);
    }
}
