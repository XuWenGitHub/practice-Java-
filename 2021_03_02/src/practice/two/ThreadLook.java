package practice.two;

public class ThreadLook{
    Integer a = 0;
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadLook obj = new ThreadLook();
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    int i=0;
                    for (int j = 0; j < 10000; j++) {
                        i+=j;
                        if(j==9999)
                            System.out.println(i);
                    }
                }
            };
            t.start();
        }
    }
}
