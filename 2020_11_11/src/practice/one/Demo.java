package practice.one;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/11/11 22:24
 * Introduce:
 */
public class Demo {
    public static volatile int a = 1;

    public void method2() {
        System.out.println(a);
    }

    public void method() {


        //a = 1;
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        //Demo.a = 2;
        //synchronized (this) {
        a = 1;
        System.out.println(a);
        if (a == 1 && a == 2) {
            System.out.println("可能");
        }
//            a=2;
        //}
        //a = 2;

    }

    public static void main(String[] args) {
        Demo d = new Demo();
        Demo d2 = new Demo();
        //Demo.a = 10;
        // d.method2();
        // d2.method2();
        for (int i = 0; i < 1000000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Demo.a=2;
                    d.method();
                    //Demo.a = 2;
                }
            }).start();
            //Demo.a = 2;
        }

    }
}
