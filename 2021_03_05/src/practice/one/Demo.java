package practice.one;

public class Demo {
    public static synchronized void decrement(){
        COUNT--;
    }
    public static synchronized void increment(){
        COUNT++;
        decrement();
    }
    private static int COUNT = 0;
    public static void main(String[] args) throws InterruptedException {
        Class<Demo> demoClass = Demo.class;
        System.out.println(demoClass==Demo.class);
        Thread[] threads = new Thread[20];
        Demo d = new Demo();
        for (int i = 0; i < 19; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        synchronized (demoClass) {
                            COUNT++;
                        }
                    }
                }
            });
        }
        threads[19] = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
//                    d.increment();
                    increment();
                }
            }
        });
        for (Thread t:threads) {
            t.start();
        }
        for(Thread t:threads){
            t.join();
        }
        System.out.println(COUNT);
    }
}
