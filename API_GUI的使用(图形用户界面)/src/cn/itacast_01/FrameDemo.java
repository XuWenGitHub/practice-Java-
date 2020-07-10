package cn.itacast_01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameDemo {
    public static void main(String[] args) {
        //创建窗体对象
        Frame f = new Frame("窗体关闭案例");

        //设置窗体属性
        f.setBounds(400,200,400,300);

        //让窗体关闭
        //事件源
        //事件：对窗体的处理
        //事件处理：关闭窗口
        //事件监听
//        f.addWindowListener(new WindowListener() {
//            @Override
//            public void windowOpened(WindowEvent windowEvent) {
//
//            }
//
//            @Override
//            public void windowClosing(WindowEvent windowEvent) {
//                System.exit(0);
//            }
//
//            @Override
//            public void windowClosed(WindowEvent windowEvent) {
//
//            }
//
//            @Override
//            public void windowIconified(WindowEvent windowEvent) {
//
//            }
//
//            @Override
//            public void windowDeiconified(WindowEvent windowEvent) {
//
//            }
//
//            @Override
//            public void windowActivated(WindowEvent windowEvent) {
//
//            }
//
//            @Override
//            public void windowDeactivated(WindowEvent windowEvent) {
//
//            }
//        });

        //用适配器改进
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        //设置窗体可见
        f.setVisible(true);
    }
}
