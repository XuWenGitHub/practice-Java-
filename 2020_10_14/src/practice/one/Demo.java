package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/14 10:53
 * Introduce:
 */
public class Demo {
//    static class ThreadDemo extends Thread{
//        @Override
//        public void run() {
//            System.out.println(Thread.currentThread().getName()+"执行ing");
//        }
//    }
    static class ThreadDemo implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"执行ing");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadDemo(),"asd");
        thread.start();
        System.out.println(Thread.currentThread().getName()+"执行ing");

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"执行ing");
        },"asda");
        thread1.start();
        thread1.join(); //当thread1join后，只能等待它完成后，其他线程才能拿到时间片

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"奥术大师");
            }
        }).start();


    }
}
