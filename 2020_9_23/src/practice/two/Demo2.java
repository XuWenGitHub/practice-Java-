package practice.two;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo2
 * @Author: XuWen
 * Date: 2020/9/23 17:51
 * Introduce:
 */
public class Demo2<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();   //生产者
    private Condition consumer = lock.newCondition();   //消费者

    public void put(T t){
        try {
            lock.lock();
            while (list.size()==MAX){
                producer.await();
            }
            list.add(t);
            ++count;
            consumer.signalAll();   //通知消费者线程运行消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get(){
        T t=null;
        try{
            lock.lock();
            while(list.size()==0){
                consumer.await();
            }
            t = list.removeFirst();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        Demo2<String> demo2 = new Demo2<>();
        Random random = new Random();
        //开启10个消费者
        for(int i=0;i<10;i++){
            new Thread(()->{
                for(int j=0;j<5;j++) {
                    System.out.println(demo2.get());
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开启2个生产者
        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++) {
                    demo2.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
