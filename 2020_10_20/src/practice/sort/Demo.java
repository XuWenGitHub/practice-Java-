package practice.sort;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

/**
 * @PackgeName: practice.sort
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/19 16:08
 * Introduce:用来测试排序算法的时间
 */
public class Demo {
    private static int[] getArr(int len){
        int[] arr = new int[len];
        Random random = new Random(232141253);
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100);   //[0,100)随机数
        }
        return arr;
    }
    public static void main(String[] args) {
//        Sort[] sorts ={
//                new MergeSort(),
//                new QuickSort(),
//                new ShellSort(),
//                new HeapSort()
//        };
//        int[] arr = getArr(10);
//        System.out.println(Arrays.toString(arr));
//        sorts[3].sort(arr);
//        System.out.println(Arrays.toString(arr));

//        for(Sort sort:sorts){
//            int[] arr2 = getArr(10000000);
//            System.out.println(sort.getName()+"开始");
//            long start = System.currentTimeMillis();
//            sort.sort(arr2);
//            long end = System.currentTimeMillis();
//            System.out.println(sort.getName()+"花费了时间"+(end-start)+"毫秒");
//        }


    }
}
