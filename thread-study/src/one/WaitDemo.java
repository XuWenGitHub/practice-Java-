package one;

public class WaitDemo {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();
        Thread thread = new Thread(() -> {
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    if (i == 5) {
                        try {
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (o){
//            try {
//                o.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("唤醒thread");
            o.notify();
        }
    }
}
