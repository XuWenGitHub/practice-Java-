package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: King
 * @Author: XuWen
 * Date: 2020/10/27 16:39
 * Introduce:  帅和将的走法规则
 */
public class King extends ChessHanlder {
    @Override
    public boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr) {
        //算出第二次点击-第一次点击的行和列的差值
        int row = endPoint.getRow()-startPoint.getRow();
        int col = endPoint.getCol()-startPoint.getCol();

        //判断是否只走了一步
        if(Math.abs(row)+Math.abs(col)==1){
            //判断没有出皇宫
            if(endPoint.getRow()>=7&&endPoint.getCol()>=3&&endPoint.getCol()<=5){
                return true;
            }
        }

        //如果两个将面对面的话，是可以吃掉对面的将,
        //依次循环当前列，去查找有没有另外一个将的存在
        int count = 0;
        //从第一次点击的棋子的行一直循环到第二次点击的棋子的行
        //如果在这个循环中，行：i  列：第一次点击的棋子的列  这个下标一个棋子都没有挡住
        //那么就说明两个将面对面，就可以吃掉对面的将
        //这个循环找第一次点击的行-1和第二次点击的行+1这一条线是否有棋子挡路
        for(int i=startPoint.getRow()-1;i>endPoint.getRow();i--){
            String iconStr = lblChessArr[i][startPoint.getCol()].getIcon().toString();
            if(iconStr.length()>10){    //确认有棋子挡住
                count++;    //给挡着的棋子计数一下
                break;
            }
        }

        if(count==0){   //如果退出循环了，还没有一个棋子挡住的话
            //还需要判断第二次点击的是将，才可以吃掉
            String kingStr = lblChessArr[endPoint.getRow()][startPoint.getCol()].getIcon().toString();
            //判断第二次点击的位置不为空，且包含将,才可以落子
            if(kingStr.length()>10&&kingStr.contains("将")) {
                return true;
            }
        }
        return false;
    }
}
