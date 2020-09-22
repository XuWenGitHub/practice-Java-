package practice.three;
//一个同步方法可以条用另一个同步方法
//一个线程已经拥有某个对象的锁，再次申请的时候，仍然会得到该对象的锁
class T{
    int count=0;
    public T() {
    }
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+"m1开始");
        method2();
        System.out.println(Thread.currentThread().getName()+"m1结束");
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+"m2开始");
        System.out.println(Thread.currentThread().getName()+"m2结束");
    }
}
/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 10:40
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        T t = new T();
        new Thread(t::method1).start();

    }
}
