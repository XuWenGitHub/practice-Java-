package chess.entity;

import java.io.Serializable;

/**
 * @PackgeName: chess.entity
 * @ClassName: ChessRecord
 * @Author: XuWen
 * Date: 2020/10/30 17:15
 * Introduce:下棋的每一步记录，悔棋操作
 */
public class ChessRecord implements Serializable {

    private static final long serialVersionUID = -5808203723295779098L;

    private ChessPoint startPoint;
    private ChessPoint endPoint;

    public ChessPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(ChessPoint startPoint) {
        this.startPoint = startPoint;
    }

    public ChessPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(ChessPoint endPoint) {
        this.endPoint = endPoint;
    }
}
