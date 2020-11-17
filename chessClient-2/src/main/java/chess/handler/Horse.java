package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: Horse
 * @Author: XuWen
 * Date: 2020/10/27 15:54
 * Introduce:   马的走法和规则
 */
public class Horse extends ChessHanlder {
    @Override
    public boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr) {
        //算出第二次点击-第一次点击的行和列的差值
        int row = endPoint.getRow()-startPoint.getRow();
        int col = endPoint.getCol()-startPoint.getCol();

        int midRow = (endPoint.getRow()+startPoint.getRow())/2;
        int midCol = (endPoint.getCol()+startPoint.getCol())/2;

        //列发生两个数的变化的别脚位置的JLabel
        JLabel jLabel1 = lblChessArr[startPoint.getRow()][midCol];
        //列发生两个数的变化的别叫位置的图像的字符串形式
        String icon1Str = jLabel1.getIcon().toString();

        //行发生两个数的变化的别脚位置的JLabel
        JLabel jLabel2 = lblChessArr[midRow][startPoint.getCol()];
        //行发生两个数的变化的别脚位置的图像的字符串形式
        String icon2Str = jLabel2.getIcon().toString();

        //判断马是否走的日字
        if(Math.abs(row)*Math.abs(col)==2){
            //列发生两个数变化，行发生一个数变换,判断是否别脚
            if(Math.abs(row)==1&&(icon1Str==null||"".equals(icon1Str))){
                return true;
            }

            //列发生一个数变化，行发生两个数变化,判断是否别脚
            if(Math.abs(col)==1&&(icon2Str==null||"".equals(icon2Str))){
                return true;
            }

        }

        return false;
    }
}
