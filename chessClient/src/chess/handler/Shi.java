package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: Shi
 * @Author: XuWen
 * Date: 2020/10/27 14:54
 * Introduce:士的规则系统，传进来第一次点击的棋子和第二次点击的棋子
 */
public class Shi extends ChessHanlder{

    @Override
    public boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr) {
        //算出第二次点击-第一次点击的行和列的差值
        int row = endPoint.getRow()-startPoint.getRow();
        int col = endPoint.getCol()-startPoint.getCol();

        if(Math.abs(row)*Math.abs(col)==1){ //判断是否走的斜
            //还要判断第二次点击的位置是否在皇宫内
            if(endPoint.getRow()>=7&&endPoint.getCol()>=3&&endPoint.getCol()<=5){
                //有一个小bug！！！
                //可能吃掉自己家的士
                return true;
            }
        }
        return false;
    }
}
