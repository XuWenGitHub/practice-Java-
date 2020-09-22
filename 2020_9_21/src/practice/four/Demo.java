package practice.four;
//子类的同步方法调用父类的同步方法可以吗？
//可以
/**
 * @PackgeName: practice.four
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 10:54
 * Introduce:
 */
public class Demo {
    public static void main(String[] args) {
        Fu f = new Zi();
        new Thread(new Runnable() {
            @Override
            public void run() {
                f.method();
            }
        },"1").start();
    }
}
class Fu{
    public Fu() {
    }
    public synchronized void method(){
        System.out.println("父开始了"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("父结束了"+Thread.currentThread().getName());
    }
}
class Zi extends Fu{
    public Zi() {
        super();
    }

    @Override
    public synchronized void method() {
        System.out.println("子开始了"+Thread.currentThread().getName());
        super.method();
        System.out.println("子结束了"+Thread.currentThread().getName());
    }
}
