package chess.handler;

import chess.entity.ChessPoint;

import javax.swing.*;

/**
 * @PackgeName: chessClient.handler
 * @ClassName: ChessHanlder
 * @Author: XuWen
 * Date: 2020/10/27 14:47
 * Introduce: 规则系统，用于判断每个棋子走法是否满足规则
 */
public abstract class ChessHanlder {

    //所有棋子继承该抽象类
    //棋子走法统一规则系统
    public abstract boolean validate(ChessPoint startPoint, ChessPoint endPoint, JLabel[][] lblChessArr);

    /**
     * 根据传进来的字符串，判断点击的是什么棋子，然后再返回该棋子的实例化对象
     * @param chessIconStr  传进来的字符串
     * @return  返回该字符串对应的棋子的实例化对象，对象有一个校验规则的方法
     */
    public static ChessHanlder getInstance(String chessIconStr){
        ChessHanlder chessObj = null;

        //判断chessIconStr是什么棋子,返回对应的实例化对象
        if(chessIconStr.contains("卒")){
            chessObj = new Army(); //创造兵的实例化对象
        }else if(chessIconStr.contains("士")){
            chessObj = new Shi();   //创造士的实例化对象
        }else if(chessIconStr.contains("相")){
            chessObj = new Elephant();  //创造相的实例化对象
        }else if(chessIconStr.contains("马")){
            chessObj = new Horse(); //创造马的实例化对象
        }else if(chessIconStr.contains("将")){
            chessObj = new King();  //创造将和帅的实例化对象
        }else if(chessIconStr.contains("车")){
            chessObj = new Car();   //创建车的实例化对象
        }else if(chessIconStr.contains("炮")){
            chessObj = new Pao();   //创建炮的实例化对象
        }else {
            throw new RuntimeException("第一次点击的都验证过必须要有棋子，但还是不存在这些棋子，就出bug！！！");
        }

        return chessObj;
    }

}
