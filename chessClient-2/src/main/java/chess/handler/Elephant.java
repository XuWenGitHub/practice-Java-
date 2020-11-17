package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: Elephant
 * @Author: XuWen
 * Date: 2020/10/27 15:31
 * Introduce:象的走棋规则
 */
public class Elephant extends ChessHanlder {
    @Override
    public boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr) {
        //算出第二次点击-第一次点击的行和列的差值
        int row = endPoint.getRow()-startPoint.getRow();
        int col = endPoint.getCol()-startPoint.getCol();

        //得到象走中间这个点的行和列(也就是别脚位置下标)
        int midRow=(endPoint.getRow()+startPoint.getRow())/2;
        int midCol=(endPoint.getCol()+startPoint.getCol())/2;

        //获得中间这个棋子的对象的icon（图像)
        Icon icon = lblChessArr[midRow][midCol].getIcon();
        //获取中间这个棋子的图像的字符串形式,如果是空说明中间没有棋子别脚
        String iconStr = icon.toString();

        //相的走法，考虑别脚
        if(Math.abs(row)*Math.abs(col)==4){ //判断象是否走的田
            //判断没有过河和没有别脚
            if(endPoint.getRow()>4&&(iconStr==null||"".equals(iconStr))){    //判断没有过河和没有别脚
                return true;
            }
        }
        return false;
    }
}
