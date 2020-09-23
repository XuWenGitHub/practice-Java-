package practice.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/22 18:21
 * Introduce:面试题：自己定义一个容器，线程A往里面添加10个元素，
 * 线程B监视，当线程A添加第5个，线程B退出，给出提示
 */
public class Demo {

    public List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Demo d = new Demo();
        //Object o = new Object();    //锁
        //Object o2 = new Object();   //锁2

        //method3(d);
        //method(d);
        method2(d);
    }
    public static void method2(Demo d){
        //给线程B上锁（1），当线程C添加第五个元素的时候，然后latch2.countDown
        CountDownLatch latch2 = new CountDownLatch(1);

        //给线程A上锁（1），当线程C全部执行完毕之后，然后latch1.countDown
        CountDownLatch latch1 = new CountDownLatch(1);



        //线程A
        new Thread(()->{
            System.out.println("线程A开始");
            try {
                latch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(d.list);
            System.out.println("线程A结束");
        },"A").start();

        //线程B
        new Thread(()->{
            System.out.println("线程B开始");
            try {
                latch2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程B结束");
        },"B").start();

        //线程C
        new Thread(()->{
            System.out.println("线程C开始");
            for(int i=1;i<=10;i++){
                if(i==5){
                    latch2.countDown();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d.list.add(i);
                System.out.println(i);
            }

            System.out.println("线程C结束");
            latch1.countDown();
        }).start();
    }



    public static void method(Demo d){
        CountDownLatch latch = new CountDownLatch(1);   //门栓

        //线程B
        new Thread(()->{
            System.out.println("线程B开始");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程B结束");
        },"B").start();

        //线程A
        new Thread(()->{
            System.out.println("线程A开始");
            for(int i=1;i<=10;i++){
                if(i==5){
                    latch.countDown();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d.list.add(i);
                System.out.println(i);
            }
            System.out.println("线程A结束");
        },"A").start();
    }

    public static void method3(Demo d){
        Object o = new Object();
        //线程B
        new Thread(()->{
            synchronized (o){
                System.out.println("线程B开始");
                try {
                    System.out.println("线程B开始等待");
                    o.wait();   //线程等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程B结束");
                o.notify();
                System.out.println("线程B唤醒线程A");
            }
        },"B").start();

        //线程C
//        new Thread(()->{
//            synchronized (o){
//                System.out.println("C线程等待");
//                try {
//                    o.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(d.list);
//                o.notify();
//            }
//        }).start();

        //线程A
        new Thread(()->{
            synchronized (o){
                System.out.println("线程A开始");
                for(int i=1;i<=10;i++){
                    if(i==5){
                        o.notify();
                        System.out.println("线程A唤醒线程B");
                        try {
                            System.out.println("线程A开始等待，释放锁");
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    d.list.add(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
                // o.notify();
            }
        },"A").start();
    }

}
