package practice.two;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @PackgeName: practice.two
 * @ClassName: WorkStealingPool
 * @Author: XuWen
 * Date: 2020/10/13 18:19
 * Introduce:
 */
public class WorkStealingPool {
    public static void main(String[] args) throws IOException {
        //这个工作偷取线程,这个会根据cpu几核然后自己在线程池里创建几个线程
        //而且创建的线程都是精灵线程，守护线程，后台线程
        ExecutorService service = Executors.newWorkStealingPool();
        System.out.println(Runtime.getRuntime().availableProcessors());
        service.execute(new R(1000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        service.execute(new R(2000));
        //已经知道我的电脑cpu是8核的，我现在添加9个任务，只Sleep一秒的这个线程会执行完自己的任务后
        //等第一个线程结束后自己的任务，会去窃取最后一个任务
        System.in.read();   //由于WorkStealingPool产生的是精灵线程，所以，如果主线程不产生阻塞的话，是看不到结果的
    }
    static class R implements Runnable{
        int time;
        R(int t){
            this.time = t;
        }
        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(time+" "+Thread.currentThread().getName());
        }
    }
}
