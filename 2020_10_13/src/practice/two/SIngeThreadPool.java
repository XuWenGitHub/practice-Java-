package practice.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PackgeName: practice.two
 * @ClassName: SIngeThreadPool
 * @Author: XuWen
 * Date: 2020/10/13 14:57
 * Introduce:
 */
public class SIngeThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            final int j=i;
            service.execute(()->{
                System.out.println(j+" "+Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }
}
