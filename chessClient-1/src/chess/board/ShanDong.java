package chess.board;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chess.board
 * @ClassName: ShanDong
 * @Author: XuWen
 * Date: 2020/10/31 14:58
 * Introduce:
 */
public class ShanDong extends Thread {
    ChessPoint startPoint;  //第一次点击的棋子
    ChessFrame chessFrame;  //棋盘对象
    public ShanDong(ChessFrame chessFrame,ChessPoint startPoint){
        this.chessFrame = chessFrame;
        this.startPoint = startPoint;
    }
    @Override
    public void run() {
        while (chessFrame.endPoint==null&&startPoint!=null){
            Icon icon = startPoint.getIcon();   //获得第一次点击的棋子的图像
//            System.out.println(icon.toString());
            //第一次点击的JLabel对象
            JLabel jLabel = chessFrame.lblChessArr[startPoint.getRow()][startPoint.getCol()];
            //先设置为空
            jLabel.setIcon(new ImageIcon(""));
            //线程休眠
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("当前图片"+startPoint.getIcon());
                System.out.println("我被中断了");
            }
            jLabel.setIcon(icon);
            //线程休眠
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("当前图片"+startPoint.getIcon());
                System.out.println("我被中断了");
            }
        }
    }
}
