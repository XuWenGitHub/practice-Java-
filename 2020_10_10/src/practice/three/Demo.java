package practice.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/10 20:38
 * Introduce:
 */
public class Demo {
    //求1至200000中的素数用多线程
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //单线程来实现去1-200000中的素数
        Long start = System.currentTimeMillis();
        List<Integer> list = getPrime(1,200000);
        Long end = System.currentTimeMillis();
        System.out.println("单线程时间："+(end-start));

        final int cpuCoreNum = 8;   //cpu八核
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
        MyTask t1 = new MyTask(1,70000);
        MyTask t2 = new MyTask(70000,100000);
        MyTask t3 = new MyTask(100000,130000);
        MyTask t4 = new MyTask(130000,150000);
        MyTask t5 = new MyTask(150000,170000);
        MyTask t6 = new MyTask(170000,190000);
        MyTask t7 = new MyTask(190000,195000);
        MyTask t8 = new MyTask(195000,200000);
        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);
        Future<List<Integer>> f5 = service.submit(t5);
        Future<List<Integer>> f6 = service.submit(t6);
        Future<List<Integer>> f7 = service.submit(t7);
        Future<List<Integer>> f8 = service.submit(t8);
        System.out.println("任务没有执行完，线程池的状态:");
        System.out.println(service);
        start = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        f5.get();
        f6.get();
        f7.get();
        f8.get();
        end = System.currentTimeMillis();
        System.out.println("多线程时间："+(end-start));
        System.out.println("任务执行完，线程池的状态:");
        System.out.println(service);
        service.shutdown();
        System.out.println(service);
    }

    static class MyTask implements Callable<List<Integer>>{
        int startPos;
        int endPos;
        public MyTask(int startPos,int endPos){
            this.startPos = startPos;
            this.endPos = endPos;
        }
        @Override
        public List<Integer> call() throws Exception {
            List<Integer> list = getPrime(startPos,endPos);
            return list;
        }
    }

    /**
     * 求[start,end)之间的素数
     * @param start 起始位置
     * @param end   终止位置
     * @return  中间的素数
     */
    public static List<Integer> getPrime(int start,int end){
        List<Integer> list = new LinkedList<>();
        while(start<end){
            if(isPrime(start)){
                list.add(start);
            }
            start++;
        }
        return list;
    }
    public static boolean isPrime(int a){
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
}
