package practice.three;

import java.util.TimerTask;
import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                5,  //核心线程数--->正式员工
                10, //最大线程数--->正式员工+临时工
                60,
                TimeUnit.SECONDS,   //idle线程的空闲时间：临时工最大的存活时间，超过时间就解雇掉
                new LinkedBlockingDeque<>(),//阻塞队列：任务存放的地方（快递仓库）
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(1);
                                r.run();
                                System.out.println(Thread.currentThread().getName()+"开始执行了");
                            }
                        });

                    }
                },  //创建线程的工厂类,可以存在，可以不存在。如果提供了创建线程工厂参数，那么就按照你提供的创建线程方法去创建
                new ThreadPoolExecutor.AbortPolicy()
                /**
                 * 拒绝策略：达到最大线程数且阻塞队列已满，采取拒绝策略
                 * AbortPolicy：直接抛RejectedExecutionException（不提供handler时的默认策略）
                 * CallerRunsPolicy：谁（某个线程）交给我（线程池）任务，我拒绝执行，谁自己执行
                 * DiscardPolicy：交给我的任务，直接丢弃掉
                 * DiscardOldestPolicy：丢弃阻塞队列中最旧的任务
                 */
        );//线程池创建以后，只要有任务就自动执行
        for (int i = 0; i < 20; i++) {
            //线程池执行任务：execute、submit--->提交执行一个任务
            pool.execute(new Runnable() {
                @Override
                public void run() { //如果上面创建线程池，提供了工厂类参数，那么走上面的逻辑，除非，上面调用r.run()
                    try {
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("--------------");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        //线程池有4个快捷创建方式（实际工作不使用，作为面试要了解）
        //阿里java开发手册，说明不能直接使用以下方式创建线程池
        //实际工作需要使用ThreadPoolExecutor，构造参数自己指定
        ExecutorService pool2 = Executors.newSingleThreadExecutor();    //单线程池
        ExecutorService pool3 = Executors.newCachedThreadPool();    //缓存的线程池
        ScheduledExecutorService pool4 = Executors.newScheduledThreadPool(4);    //计划任务线程池
        ExecutorService pool5 = Executors.newFixedThreadPool(4);    //固定大小的线程池

        pool4.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 2, TimeUnit.SECONDS);  //2秒后，开始

        pool4.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("闹钟");
            }
        }, 2, 1, TimeUnit.SECONDS);    //2秒钟后开始执行，每间隔1秒钟后，再运行一次
        }
    }
}
