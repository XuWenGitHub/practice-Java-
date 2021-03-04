package practice.two;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread[] threads= new Thread[20];
        for(int i=0;i<20;i++){
            final int n = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(n);
                }
            });
        }
        for(Thread t: threads){
            t.start();
        }
        //run运行，idea会帮你开启一个线程，所以永远存活线程数为2，main和idea开启的线程
        //但是debug，idea就不会帮忙开启一个线程
        while (Thread.activeCount()>1){
            Thread.yield(); //当前线程让步，从运行态转变为就绪态
        }
        System.out.println("ok");
    }
}
