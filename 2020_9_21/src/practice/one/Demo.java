package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 10:12
 * Introduce:
 */
//程序在执行过程中，如果出现异常，默认情况下锁会被释放
public class Demo {
    //Demo d = new Demo();    //锁
    int count=0;
    public synchronized void method(){
        System.out.println(Thread.currentThread().getName()+"开始");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //count++;
            System.out.println(++count);
            if(count==5){
                System.out.println(1/0);    //抛出算数异常，然后会释放this这个锁
            }
        }
    }
    //如果method方法中，出现算数异常后，如果没有释放this这个锁的话，就不会执行method2
    //如果释放了这个锁的话，那么就会执行
    public synchronized void method2(){

        System.out.println(Thread.currentThread().getName()+"开始");
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(++count);
            if(count==100){
                System.out.println(Thread.currentThread().getName()+"结束");
                break;
            }
        }
        //System.out.println(Thread.currentThread().getName()+"结束");
    }
    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(d::method,"m1").start();
        new Thread(d::method2,"m2").start();
    }
}
