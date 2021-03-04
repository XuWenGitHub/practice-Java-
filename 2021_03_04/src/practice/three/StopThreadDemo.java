package practice.three;

public class StopThreadDemo {
    private static volatile boolean STOP = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //执行任务，执行事件可能比较长
                for(int i=0;i<100000&&!STOP;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        System.out.println("t start");
        //模拟，t执行了5秒，还没有结束，要中断，停止t线程
        Thread.sleep(5000);
        STOP = true;
        //让t线程中断，停止
        System.out.println("t stop");
    }
}
