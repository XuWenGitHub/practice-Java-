package practice.two;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/23 17:12
 * Introduce:   用wait和notifyAll实现生产者消费者模式
 */
/*
面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
能够支持2个生产者线程及10个消费者线程的阻塞调用
 */
public class Demo<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final int MAX = 10;
    private int count=0;

    public synchronized void put(T e){
        while(list.size()==MAX){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        list.add(e);
        ++count;
        this.notifyAll();
    }

    public synchronized T get(){
        T t=null;
        while(list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        --count;
        this.notifyAll();
        return t;
    }

    public int getCount(){
        return list.size();
    }

    public static void main(String[] args) {

        Demo<String> demo = new Demo<>();


        for(int i=0;i<10;i++){
            new Thread(()->{
               // Integer j=demo.get();
                for(int j=0;j<5;j++) {
                    System.out.println(demo.get());
                }
            },"consumer"+i).start();
        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++) {
                    demo.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
