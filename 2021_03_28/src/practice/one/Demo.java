package practice.one;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    System.out.println(i);
                    countDownLatch.countDown();
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("我醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
        thread.start();

    }
}
