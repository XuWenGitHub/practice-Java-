package practice.two;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/14 11:08
 * Introduce:   求10000000个数的和
 */
public class Demo {
    static int[] nums = new int[10000];
    static {
        for(int i=0;i<nums.length;i++){
            nums[i] = new Random().nextInt(10);
        }
        System.out.println(Arrays.stream(nums).sum());
    }
    static class MyTask implements Callable<Integer> {
        int start,end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int res = 0;
            for(int i=start;i<end;i++){
                res+=nums[i];
            }
            return res;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask1 = new MyTask(0,nums.length/2);
        MyTask myTask2 = new MyTask(nums.length/2,nums.length);
        FutureTask<Integer> futureTask1 = new FutureTask<>(myTask1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(myTask2);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        Integer res1 = futureTask1.get();
        Integer res2 = futureTask2.get();
        System.out.println((res2+res1));
    }
}
