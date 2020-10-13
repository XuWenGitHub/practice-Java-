package practice.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @PackgeName: practice.two
 * @ClassName: CachedThreadPool
 * @Author: XuWen
 * Date: 2020/10/13 14:41
 * Introduce:
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("刚创建线程:");
        System.out.println(service);
        for(int i=0;i<2;i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println("两个线程在运行中");
        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("80秒后,看开启了线程，空闲了60秒后，会自动销毁吗");
        System.out.println(service);
    }
}
