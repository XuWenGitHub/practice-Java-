package practice.four;

public class ThreadDemo {
    int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        ThreadDemo d = new ThreadDemo();
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable(){
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        synchronized (d){
                            d.count+=1;
                        }

                    }
                }
            });
        }
        for(int i=0;i<20;i++){
            threads[i].start();
        }
        for(int i=0;i<20;i++){
            threads[i].join();
        }
        System.out.println(d.count);
    }
}
