package practice.three;


import java.sql.Time;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //执行任务，执行事件可能比较长
                for(int i=0;i<100000&&!Thread.currentThread().isInterrupted();i++){
                    System.out.println(Thread.interrupted());
                    System.out.println(i);
                    try {
                        System.out.println(Thread.interrupted());
                        System.out.println("我开始休眠");
                        Thread.sleep(1000000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();//线程启动，中断标志位=false
        System.out.println("t start");
        //模拟，t执行了5秒，还没有结束，要中断，停止t线程
        Thread.sleep(2000);
        //告诉t线程，要中断（设置t线程的中断标志位为true），由t的代码自行决定是否中断
        //如果t线程处于阻塞状态，会抛出InterruptedException，并且重置t线程的中断标志位
        t.interrupt();//告诉t线程，要中断（设置t线程的中断表示为true，这个中断标志位，是jvm提供的）
        //让t线程中断，停止
        System.out.println("t stop");
    }
}

