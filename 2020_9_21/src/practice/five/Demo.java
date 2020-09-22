package practice.five;
//死锁现象

/**
 * @PackgeName: practice.five
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 10:59
 * Introduce:
 */
public class Demo {
    Object a = new Object();   //A锁
    Object b = new Object();    //B锁
    public void method1(){
        synchronized (a) {
            System.out.println("m1开始了");
            System.out.println("m1占用了a锁~~~");
            //先休息3秒
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("m1上了a锁，m1还在等待b锁的释放~~~");
            System.out.println("死锁了，m1上了a的锁，m1在等b锁的释放");
            System.out.println("m2上了b的锁，m2在等a的锁的释放");
            synchronized (b){
                System.out.println("已经死锁");
            }
        }
    }
    public void method2(){
        synchronized(b){
            System.out.println("m2开始了");
            System.out.println("m2占用了b锁");

            System.out.println("m2上了b锁，在m2等待a锁的释放~~~");
            synchronized (a){
                System.out.println("死锁");
            }
        }
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(d::method1).start();
        new Thread(d::method2).start();
    }
}
