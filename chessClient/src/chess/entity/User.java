package chess.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @PackgeName: chess.entity
 * @ClassName: User
 * @Author: XuWen
 * Date: 2020/10/28 13:31
 * Introduce:   封装登录账号和密码的实体对象
 */
public class User implements Serializable {

    //因为这个对象是要进行IO流对象传输，所以就要实现序列化接口，拿到UID
    /**
     * 分配一个序列化ID，如果用到IO流进行对象传输的话，那就必须将该对象序列化
     * 因为传过去的时候要通过通道，然后对象要变成二进制，然后传过去
     * 最后服务器接收的时候，就需要通过反序列化，把二进制又变成对象
     */
    private static final long serialVersionUID = -3172304247245917868L;

    //用户名
    private String username;
    //密码
    private String password;

    //判断登录是否成功
    private Boolean loginSuccessFlag;

    //1代表红方 2代表黑房
    private Integer color;

    //1代表准备
    //1代表申请准备,0代表还没有准备
    private Integer ready;

    //消息类型
    private StatusEnum status;

    //动与不动，true表示可以动
    private Boolean moveFlag;

    //每次走棋，要传给服务器位置
    //记录第一个点击的棋子
    private ChessPoint startPoint=null;

    //记录第二个点击的棋子
    private ChessPoint endPoint=null;

    //1-红方赢，2-黑方赢
    private Integer win;

    //聊天文字集合
    private List<FontStyle> fonts;

    public List<FontStyle> getFonts() {
        return fonts;
    }

    public void setFonts(List<FontStyle> fonts) {
        this.fonts = fonts;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

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

    public Boolean getMoveFlag() {
        return moveFlag;
    }

    public void setMoveFlag(Boolean moveFlag) {
        this.moveFlag = moveFlag;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getReady() {
        return ready;
    }

    public void setReady(Integer ready) {
        this.ready = ready;
    }


    public Boolean getLoginSuccessFlag() {
        return loginSuccessFlag;
    }

    public void setLoginSuccessFlag(Boolean loginSuccessFlag) {
        this.loginSuccessFlag = loginSuccessFlag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //是用来服务器来判断是哪一个操作
    public enum StatusEnum{
        LOGIN(1,"登录"),READY(2,"下棋准备"),START(3,"开始下棋"),
        HUIQI(4,"悔棋"),RUN(5,"下棋"),CHAT(6,"聊天"),
        HQSQ(7,"悔棋申请"),AGREE(8,"同意悔棋"),REJECT(9,"拒绝悔棋"),
        DD(10 , "窗体抖动");

        private Integer status;

        private String desc;

        private StatusEnum(Integer status,String desc){
            this.status = status;
            this.desc = desc;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
