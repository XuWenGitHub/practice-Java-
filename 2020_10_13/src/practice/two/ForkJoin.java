package practice.two;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @PackgeName: practice.two
 * @ClassName: ForkJoinPool
 * @Author: XuWen
 * Date: 2020/10/13 18:36
 * Introduce:分叉合并池来计算2000000个随机数的和，和单线程计算随机数的和来做比较
 */
public class ForkJoin{
    static int[] nums = new int[2000000];
    static final int MAX_NUM = 50000;   //表示每个线程最多计算50000个数的和
    static Random r = new Random();
    //静态代码块，每次启动程序
    static {
        for(int i=0;i<nums.length;i++){
            nums[i] = r.nextInt(100);
        }
        Long start = System.currentTimeMillis();
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res+=nums[i];
        }
        Long end = System.currentTimeMillis();
        System.out.println("单线程计算的结果："+ res+"运行的时间为： "+(end-start));
    }

    /*//代表我们分的任务
    //因为这个任务继承的RecursiveAction，这个是没有返回值的
    static class AddTask extends RecursiveAction{
        int start,end;  //代表nums中的区间，求nums[start,end)之间的值
        AddTask(int start,int end){
            this.start = start;
            this.end = end;
        }
        @Override
        protected void compute() {
            if(end-start<=MAX_NUM){ //说明目前的区间是满足我们设定的要求
                Long sum = 0L;
                for(int i=start;i<end;i++){
                    sum+=nums[i];
                }
                System.out.println("from:"+start+" to:"+end+"="+sum);
            }else{  //说明目前的区间不满足我们的要求，那么我们就需要再分一下
                int mid = (start+end)/2;
                AddTask subTask1 = new AddTask(start,mid);
                AddTask subTask2 = new AddTask(mid,end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }*/

    static class AddTask extends RecursiveTask<Long>{
        int start,end;

        AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        protected Long compute() {
            if(end-start<=MAX_NUM){
                Long sum = 0L;
                for(int i=start;i<end;i++){
                    sum+=nums[i];
                }
                return sum;
            }
            int mid = (start+end)/2;
            AddTask subTask1 = new AddTask(start,mid);
            AddTask subTask2 = new AddTask(mid,end);
            subTask1.fork();
            subTask2.fork();
            return subTask1.join()+subTask2.join();
        }
    }
    public static void main(String[] args) throws IOException {
        /*//AddTask继承的RecursiveAction，无返回值的任务
        ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        fjp.execute(task);
        System.in.read();*/

//        ForkJoinPool fjp = new ForkJoinPool();
//        AddTask task = new AddTask(0,nums.length);
//        fjp.execute(task);
//        Long result = task.join();
//        System.out.println("多线程计算的结果："+result);
//        System.in.read();

//        ForkJoinPool fjp = new ForkJoinPool();
//        AddTask task = new AddTask(0,nums.length);
//        Long res = fjp.invoke(task);
//        System.out.println(res);

        ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        Future<Long> result = fjp.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
