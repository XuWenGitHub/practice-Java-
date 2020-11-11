package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: Army
 * @Author: XuWen
 * Date: 2020/10/27 14:49
 * Introduce:   兵的规则系统，穿进来第一次点击的棋子和第二次点击的棋子
 */
public class Army extends ChessHanlder{


    @Override
    public boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr) {
        //算出第二次点击-第一次点击的行和列的差值
        int row = endPoint.getRow()-startPoint.getRow();
        int col = endPoint.getCol()-startPoint.getCol();

        //兵的走法，只能走一步,需要得到相对距离
        if(Math.abs(row)+Math.abs(col)==1){ //判断兵是否只走了一步
            //如果满足这个条件，就说明只走了一步
            //还要判断过河的情况
            if(startPoint.getRow()<5){  //代表兵过了河
                if(row==0||row<0){   //现在已经过了河并且只走了一步，如果向前走或者左右走，就ok
                    return true;
                }
            }else if(startPoint.getRow()>=5){   //代表兵没有过河
                if(row<0){  //起点位置-终点位置为负数肯定就是负数
                    return true;    //说明没有过河，且只往前走了
                }
            }

        }
        return false;
    }
}
