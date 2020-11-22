package practice.one;
class Test{
    private int data;
    int result = 0;
    public void m(){
        result+=2;
        data+=2;
        System.out.print(result+" "+data);
    }
}
class ThreadExample extends Thread{
    private Test mv;
    public ThreadExample(Test mv){
        this.mv = mv;
    }

    @Override
    public void run() {
        synchronized (mv){
            mv.m();
        }
    }
}
public class ThreadTest {
    static int i;
    public static void main(String[] args) {
        Test mv = new Test();
        Thread t1 = new ThreadExample(mv);
        Thread t2 = new ThreadExample(mv);
        Thread t3 = new ThreadExample(mv);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(Math.round(11.5)+" "+Math.round(-11.5));
        System.out.println(100%3);
        System.out.println(100%3.0);
        System.out.println(i);
    }


}
