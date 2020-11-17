package chess.board;

/**
 * @PackgeName: chess.board
 * @ClassName: DouDong
 * @Author: XuWen
 * Date: 2020/10/30 23:35
 * Introduce:   抖动的线程实现类
 */
public class DouDong extends Thread{
    ChatFrame chatFrame = null;

    public DouDong(ChatFrame chatFrame){
        this.chatFrame = chatFrame;
    }

    @Override
    public void run() {
        //用一个循环，反复的去设置上下左右的位置就可以了
        for(int i=0;i<3;i++){
            try {
                chatFrame.setLocation(chatFrame.getX()-18,chatFrame.getY());
                Thread.sleep(38);
                chatFrame.setLocation(chatFrame.getX(),chatFrame.getY()-18);
                Thread.sleep(38);
                chatFrame.setLocation(chatFrame.getX()+18,chatFrame.getY());
                Thread.sleep(38);
                chatFrame.setLocation(chatFrame.getX(),chatFrame.getY()+18);
                Thread.sleep(38);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
