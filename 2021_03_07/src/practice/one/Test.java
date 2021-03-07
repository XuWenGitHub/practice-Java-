package practice.one;

import java.util.concurrent.BlockingQueue;

public class Test {
    //i==1表示最先打印，i==2表示第二次打印，i==3表示最后打印
    private static volatile int i=1;

    private static class PrintTask implements Runnable{
        String letter;
        Integer num;

        public PrintTask(String letter, Integer i) {
            this.letter = letter;
            this.num = i;
        }

        @Override
        public void run() {
            for (int j = 0; j < 20; j++) {
                synchronized (Test.class) {
                    while (num != i) {
                        try {
                            Test.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Test.class.notifyAll();
                    if(i==1){
                        i=2;
                    }else if(i==2){
                        i=3;
                    }else{
                        i=1;
                    }
                    System.out.print(letter);
                    if(num==3){
                        System.out.println();
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        //有三个线程，每个线程只能打印A或B或C
        //要求：同时执行三个线程，按CBA顺序打印
        Thread a = new Thread(new PrintTask("C",1));
        Thread b = new Thread(new PrintTask("B",2));
        Thread c = new Thread(new PrintTask("A",3));
        a.start();
        b.start();
        c.start();
    }
}
