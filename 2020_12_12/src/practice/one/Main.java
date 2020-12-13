package practice.one;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static volatile boolean f = false;
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Object o = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (int i = 0; i < 10; i++) {
                        list.add("asd");

                        if (i == 4) {
                            //f = true;
                            o.notify();
                            try {
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        System.out.println(list);
                    }
                }
            }
        });
        Thread thread1 = new Thread(() -> {
//            while(true){
                synchronized (o) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    if (f) {
                        System.out.println("sadasd");
//                        break;
//                    }
                    o.notify();
                }
//            }
        });
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }
}
