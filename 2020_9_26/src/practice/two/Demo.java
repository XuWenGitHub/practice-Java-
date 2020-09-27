package practice.two;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/26 17:33
 * Introduce:有n张火车票，每张票有一个编号，十个线程去卖
 */
public class Demo {
    private static Deque<String> deque = new LinkedList<>();
    static {
        for(int i=0;i<1000;i++) {
            deque.add("票 编号："+(i+1) );
        }
    }

    public synchronized void sellTicket(){
        while (deque.size() > 0) {
            System.out.println("卖了" + deque.poll());
        }
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        //开启10个线程
        for(int i=0;i<10;i++){
            new Thread(()->{
                d.sellTicket();
            }).start();
        }
    }
}
