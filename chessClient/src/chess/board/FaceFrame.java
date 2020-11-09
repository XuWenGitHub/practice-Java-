package chess.board;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 * @PackgeName: chess.board
 * @ClassName: FaceFrame
 * @Author: XuWen
 * Date: 2020/10/30 23:18
 * Introduce:表情选择窗体
 */
public class FaceFrame extends JFrame{

    private static final long serialVersionUID = 5694833872433975751L;

    public FaceFrame(JTextPane txtsend){
        //可见、布局、宽度、大小
        JPanel panel = (JPanel)getContentPane();
        panel.setLayout(null);
        //用双重循环来摆图片
        for(int row = 0;row<10;row++){
            for(int col=0;col<6;col++){
                //得到图片
                ImageIcon icon = new ImageIcon("images/face/"+(6*row+col+1)+".gif");
                //将图片放到JLabel里
                JLabel lblIcon = new JLabel(icon);
                lblIcon.setSize(50,50);
                lblIcon.setLocation(0+col*50,0+row*50);
                //为lbl添加鼠标点击事件
                lblIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel jLabel = (JLabel)e.getSource();
                        Icon icon2 = jLabel.getIcon();
                        txtsend.insertIcon(icon2);
                        FaceFrame.this.dispose();
                    }
                });
                panel.add(lblIcon);
            }
        }
        setSize(320,300);
        setLocation(800,400);
        setTitle("嘻哈猴");
        setVisible(true);
    }
}
