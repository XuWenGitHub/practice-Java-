package practice.one;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
    private static Deque<String> list = new LinkedList<>();
    private static final int MAX = 100;
    private static final Lock lock = new ReentrantLock();
    private static final Condition producer = lock.newCondition();
    private static final Condition consumer = lock.newCondition();
    private static final Random random = new Random();


    public static void put() {
        while (true) {
            try {
                lock.lock();    //上锁
                while (list.size() == MAX) {
                    producer.await();   //当前生产者等待
                }
                list.add(random.nextInt(100) + 1 + ""); //生产数据
                consumer.signalAll();   //唤醒所有等待的消费者


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();  //释放锁
            }
        }
    }


    public static String get() {
        while (true) {
            try {
                lock.lock();    //上锁
                while (list.size() == 0) {
                    consumer.await();   //当前消费者等待
                }
                producer.signalAll();   //唤醒所有等待的生产者
                return list.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();  //释放锁
            }
        }
    }


    public static void main(String[] args) {
        //开启两个生产者一直生产
        for(int i=0;i<2;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    put();
                }
            }).start();
        }

        //开启10消费者一直消费
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(get()+"："+Thread.currentThread().getName());
                    }
                }
            },i+"").start();
        }
    }
}
