package chess.entity;

import javax.swing.*;
import java.io.Serializable;

/**
 * @PackgeName: chessClient.entity
 * @ClassName: ChessPoint
 * @Author: XuWen
 * Date: 2020/10/26 22:39
 * Introduce: JLabel棋子的信息记录
 */
public class ChessPoint implements Serializable {

    private static final long serialVersionUID = 2807712586694798272L;


    private int row;    //当前棋子的行
    private int col;    //当前棋子的列
    private Icon icon;  //一个小的固定大小图片，通常用于装饰组件。
    private String iconName;    //对象传输不支持icon,就传名字

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
