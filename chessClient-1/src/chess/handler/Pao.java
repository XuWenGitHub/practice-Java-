package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: Car
 * @Author: XuWen
 * Date: 2020/10/27 17:10
 * Introduce:炮的走棋规则
 */
public class Pao extends ChessHanlder{
    @Override
    public boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr) {
        //算出第二次点击-第一次点击的行和列的差值
        int row = endPoint.getRow()-startPoint.getRow();
        int col = endPoint.getCol()-startPoint.getCol();


        int count = 0;  //表示炮走的路线是否有遮拦物，并且统计个数
        boolean flag = false;   //表示炮满足只能横着走或者竖着走

        //炮竖着走：第一次点击和第二次点击的列相等
        if(startPoint.getCol()==endPoint.getCol()){
            flag = true;//表示炮满足只能横着走或者竖着走

            if(row>0){  //竖着从上往下走   ↓
                //循环判断起始点和落子点之间是否有挡住的
                for(int i=startPoint.getRow()+1;i<endPoint.getRow();i++){
                    String iconStr = lblChessArr[i][startPoint.getCol()].getIcon().toString();
                    if(iconStr.length()>10){
                        //中间有子
                        count++;
                    }
                }
            }else{  //竖着从下往上走 ↑
                //循环判断起始点和落子点之间是否有挡住的
                for (int i=startPoint.getRow()-1;i>endPoint.getRow();i--){
                    String iconStr = lblChessArr[i][startPoint.getCol()].getIcon().toString();
                    if(iconStr.length()>10){    //判断当前位置是否是一个棋子
                        //中间有棋子
                        count++;
                    }
                }
            }


        //炮横着走，第一次点击和第二次点击的行相等
        }else if(startPoint.getRow()==endPoint.getRow()){ //车横着走，第一次点击和第二次点击的行相等
            flag = true;//表示炮满足只能横着走或者竖着走

            if(col>0){  //横着走，从左往右走 →
                for(int i=startPoint.getCol()+1;i<endPoint.getCol();i++){
                    String iconStr = lblChessArr[startPoint.getRow()][i].getIcon().toString();
                    if(iconStr.length()>10){    //看当前位置是否是一个棋子
                        count++;    //遮拦物++
                    }
                }
            }else{  //横着从右往左走   ←
                for(int i=startPoint.getCol()-1;i>endPoint.getCol();i--){
                    String iconStr = lblChessArr[startPoint.getRow()][i].getIcon().toString();
                    if(iconStr.length()>10){    //看当前位置是否是一个棋子
                        count++;    //遮拦物+1
                    }
                }
            }



        }

        //flag表示炮是否遵循规则横着走或者竖着走
        //不然就会出现bug，炮可以随意走，因为上面if和if else都没有进去
        if(count==0&&flag){   //中间没有棋子挡住,落子点不能出现棋子,这种情况就是跑简单的走不吃棋子
            //判断落子上没有字，因为炮不能像车一样那么直接吃
            String louziIcon = lblChessArr[endPoint.getRow()][endPoint.getCol()].getIcon().toString();
            if(louziIcon.length()<2){
                //落子点没有棋子,就可以落
                return true;
            }
        }
        if(count==1&&flag){   //中间有一个棋子挡住，落子点必须要出现棋子,这样就是隔山打
            //判断落子点上有字，炮可以隔着一个打一个
            String louziIcon = lblChessArr[endPoint.getRow()][endPoint.getCol()].getIcon().toString();
            if(louziIcon.length()>10){
                //落子点有棋子,就可以隔山打
                return true;
            }
        }


        return false;
    }
}
