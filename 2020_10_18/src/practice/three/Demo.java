package practice.three;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @PackgeName: practice.three
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/18 19:49
 * Introduce:
 */
public class Demo {
    //生成一个伪随机数的数组
    public static int[] createArr(){
        int[] arr = new int[10];
        Random random = new Random(12345);
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
    public static void main(String[] args) {
//        long n = 20201018;
//        int[] arr = change(n);
//        System.out.println(Arrays.toString(arr));

        int[] arr2 = createArr();
        System.out.println(Arrays.toString(arr2));
        heapSort(arr2);
        System.out.println(Arrays.toString(arr2));

        printPyramid('a');

//        int 变量 = 1;
//        System.out.println(变量);
    }
    public static int[] change(long n){
        int post = getPost(n);
        int[] arr = new int[post];
        for(int i=arr.length-1;i>=0;i--){
            arr[i] =(int)(n%10);
            n/=10;
        }
        return arr;
    }
    //算一个数的位数
    public static int getPost(long n){
        if(n==0){
            return 1;
        }
        int res=0;
        while (n!=0){
            n/=10;
            res++;
        }
        return res;
    }
    //希尔排序：就是对数组分组插入排序
    public static void shellSort(int[] arr){
        int group = arr.length/2;
        while (group>0){
            groupInsertSort(arr,group);
            group/=2;
        }
    }
    //对数组分组插入排序
    public static void groupInsertSort(int[] arr,int group){
        for(int i=group;i<arr.length;i++){
            int temp = arr[i];  //待插入元素
            int j;
            for(j=i-group;j>=0;j-=group){
                if(arr[j]>temp){
                    arr[j+group] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+group] = temp;
        }
    }
    //堆排序
    public static void heapSort(int[] arr){
        createHeap(arr,arr.length);
        for(int i=0;i<arr.length-1;i++){    //趟数
            int maxValue = arr[0];
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = maxValue;
            adjustDown(arr,arr.length-i-1,0);
        }
    }
    //建堆
    public static void createHeap(int[] arr,int size){
        int lastIndexParent = (size-2)/2;
        for(int i = lastIndexParent;i>=0;i--){
            adjustDown(arr,size,i);
        }
    }
    //向下调整
    public static void adjustDown(int[] arr,int size,int index){
        while(true){
            int leftIndex = index*2+1;
            if(leftIndex>=size){
                break;
            }
            int maxIndex = leftIndex;
            if(leftIndex+1<size&&arr[leftIndex+1]>arr[leftIndex]){
                maxIndex = leftIndex+1;
            }
            if(arr[index]>=arr[maxIndex]){
                break;
            }
            int t = arr[maxIndex];
            arr[maxIndex] = arr[index];
            arr[index] = t;

            index = maxIndex;
        }
    }

    //循环打印金字塔
    public static void printPyramid(char c){
        int num = 1;    //代表第一行只有1个
        for(int i=0;i<5;i++){   //打印三角形金字塔
            //打印空格
            for(int j=0;j<5-num;j++){
                System.out.print(" ");
            }
            //打印字符
            for(int k=0;k<num;k++){
                System.out.print(c+" ");
            }
            num+=1;
            System.out.println();
        }
    }
}
