package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: Car
 * @Author: XuWen
 * Date: 2020/10/27 17:10
 * Introduce:车的走棋规则
 */
public class Car extends ChessHanlder{
    @Override
    public boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr) {
        //算出第二次点击-第一次点击的行和列的差值
        int row = endPoint.getRow()-startPoint.getRow();
        int col = endPoint.getCol()-startPoint.getCol();

        //车竖着走：第一次点击和第二次点击的列相等
        if(startPoint.getCol()==endPoint.getCol()){
            int count=0;    //记录中间是否有棋子挡住

            if(row>0){  //竖着从上往下走   ↓
                //循环判断起始点和落子点之间是否有挡住的
                for(int i=startPoint.getRow()+1;i<endPoint.getRow();i++){
                    String iconStr = lblChessArr[i][startPoint.getCol()].getIcon().toString();
                    if(iconStr.length()>10){
                        //中间有子
                        count++;
                        break;
                    }
                }
            }else{  //竖着从下往上走 ↑
                //循环判断起始点和落子点之间是否有挡住的
                for (int i=startPoint.getRow()-1;i>endPoint.getRow();i--){
                    String iconStr = lblChessArr[i][startPoint.getCol()].getIcon().toString();
                    if(iconStr.length()>10){    //判断当前位置是否是一个棋子
                        //中间有棋子
                        count++;
                        break;
                    }
                }
            }
            if(count==0){
                return true;
            }

        //车横着走，第一次点击和第二次点击的行相等
        }else if(startPoint.getRow()==endPoint.getRow()){ //车横着走，第一次点击和第二次点击的行相等
            int count = 0;  //表示中间是否有遮拦物

            if(col>0){  //横着走，从左往右走 →
                for(int i=startPoint.getCol()+1;i<endPoint.getCol();i++){
                    String iconStr = lblChessArr[startPoint.getRow()][i].getIcon().toString();
                    if(iconStr.length()>10){    //看当前位置是否是一个棋子
                        count++;    //遮拦物++
                        break;
                    }
                }
            }else{  //横着从右往左走   ←
                for(int i=startPoint.getCol()-1;i>endPoint.getCol();i--){
                    String iconStr = lblChessArr[startPoint.getRow()][i].getIcon().toString();
                    if(iconStr.length()>10){    //看当前位置是否是一个棋子
                        count++;    //遮拦物+1
                        break;
                    }
                }
            }

            if(count==0){   //表示没有遮拦物
                return true;
            }
        }


        return false;
    }
}
