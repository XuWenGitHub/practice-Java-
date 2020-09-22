package practice.six;
//synchronized修饰静态方法，就好比synchronized(practice.six.Demo.class)
/**
 * @PackgeName: practice.six
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/21 11:38
 * Introduce:
 */
public class Demo {
    public static void method2(){
        synchronized(practice.six.Demo.class){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("静态方法加上synchronize");
            System.out.println("锁为当前类的字节码文件(要带上包路径)");
        }
    }
    public /*synchronized*/ static void method(){
        System.out.println("我开始了");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我结束了");
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                method();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                method();
            }
        }).start();
        new Thread(Demo::method2).start();
    }
}
