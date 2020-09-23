package practice.two;

import java.util.concurrent.CountDownLatch;

/**
 * @PackgeName: practice.two
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/9/22 18:35
 * Introduce:给一个数组，求数组和，利用多线程来实现
 */
public class Demo {
    /*volatile*/ int sum=0; //设置线程间可见
    public static void main(String[] args) {
        int[] arr = getArr(100000000);
        Demo d = new Demo();
        CountDownLatch latch = new CountDownLatch(2);
        //线程A来计算最后通过多线程来算出来的sum，和迭代法算出来的结果
        //给线程A上了门栓（2），分别等线程B和线程C完全执行完毕后，才会打开线程A
        new Thread(()->{
            System.out.println("线程A开始");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("多线程算的值"+d.sum);
            System.out.println("迭代法算的值"+add(arr));
            System.out.println("线程A结束");
        }).start();
        //线程B来计算[0,arr.length/2)之间的值，加入到d.sum里面
        new Thread(()->{
            System.out.println("线程B开始");
            for(int i=0;i<arr.length/2;i++){
                synchronized (d) {
                    d.sum += arr[i];
                }
            }
            latch.countDown();
            System.out.println("线程B结束");
        }).start();

        //线程C来计算[arr.length/2,arr.length)之间的值，加入到d.sum里面
        new Thread(()->{
            System.out.println("线程C开始");
            for(int i=arr.length/2;i<arr.length;i++){
                synchronized (d) {
                    d.sum += arr[i];
                }
            }
            latch.countDown();
            System.out.println("线程C结束");
        }).start();

    }
    //利用多线程求arr的和
    public static int add(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    /**
     * 开启一个线程，来算出[start,end)之间的和，返回和
     * @param arr   数组
     * @param start 起始位置
     * @param end   结束位置
     * @return  和
     */
    public int add(int[] arr,int start,int end){
        Integer res=0;
        new Thread(()->{
            //int res=0;
            for(int i=start;i<end;i++){
               // res+=arr[i];
            }

        }).start();
        return res;
    }
    public static int[] getArr(int num){
        int[] arr = new int[num];
        for(int i=1;i<num;i++){
            arr[i-1]=i;
        }
        return arr;
    }
}
