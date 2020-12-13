package practice.four;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //实现线程B
        Thread threadB = new Thread(() -> {
            if (list.size() != 5) {
                LockSupport.park();
            }
            System.out.println("asdasd");
        });
        //实现线程A
        int j=0;    //只能使用，不能修改
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("添加了一个");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    LockSupport.unpark(threadB);
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
