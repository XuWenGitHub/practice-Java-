package practice.one;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    private static volatile int count = 100;
    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition consumer = lock.newCondition();   //消费者
    public static final Condition producer = lock.newCondition();   //生产者

    public static void put(){
        try {
            lock.lock();
            while (count >= 100) {
                consumer.signalAll();
                producer.await();
            }
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static int get(){
        try {
            lock.lock();
            while (count<=0){
                producer.signalAll();
                consumer.await();
            }
            return count--;
        } catch (InterruptedException e) {
            throw new RuntimeException("asda");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //开20个消费者，10个生产者
        Thread[] consumers = new Thread[20];
        Thread[] producers = new Thread[10];
        for (int i = 0; i < 20; i++) {
            consumers[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(get());
                    }
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            producers[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        put();
                    }
                }
            });
        }
        for (int i = 0; i < 20; i++) {
            if(i<10){
                producers[i].start();
            }
            consumers[i].start();
        }
    }
}
