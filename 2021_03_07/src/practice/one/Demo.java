package practice.one;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用ReentrantLock和Condition来实现生产者消费者模式
 */
public class Demo {
    private static int count = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition producer = lock.newCondition();
    private static final Condition consumer = lock.newCondition();

    static class Producer implements Runnable{
        Integer no;
        public Producer(Integer no){
            this.no = no;
        }
        @Override
        public void run() {
            while(true){
                try {
                    lock.lock();
                    while(count==100){
                        consumer.signalAll();
                        producer.await();
                    }
                    System.out.printf("生产者%d号，生产第%d个物品\n",no,++count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        Integer no;

        public Consumer(Integer no) {
            this.no = no;
        }

        @Override
        public void run() {
            while(true){
                try {
                    lock.lock();
                    while(count==0){
                        producer.await();
                        consumer.signalAll();
                    }
                    System.out.printf("消费者%d，消费第%d个物品\n",no,count--);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //开启10个生产者，20个消费者
        Thread[] producers = new Thread[10];
        Thread[] consumers = new Thread[20];
        for (int i = 0; i < 20; i++) {
            if(i<10){
                producers[i] = new Thread(new Producer(i));
            }
            consumers[i] = new Thread(new Consumer(i));
        }
        for (int i = 0; i < 20; i++) {
            if(i<10){
                producers[i].start();
            }
            consumers[i].start();
        }

    }
}
