package practice.two;

public class Demo {
    static int a;
    public static void main(String[] args) {
        Demo d = new Demo();
        final int b = 1;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(d);
                System.out.println(a);
                System.out.println(b);
            }
        });
        t.start();
    }
}
