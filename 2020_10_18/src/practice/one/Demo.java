package practice.one;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.LongBinaryOperator;

/**
 * @PackgeName: practice.one
 * @ClassName: Demo
 * @Author: XuWen
 * Date: 2020/10/18 14:00
 * Introduce:
 */
public class Demo {

    //生成一个伪随机数的数组
    public static int[] createArr(){
        int[] arr = new int[10000000];
        Random random = new Random(12345);
        for(int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
    public static void main(String[] args) {
//        System.out.println(pow(16,2));
//        System.out.printf("%15d",pow(16,3));
//        Scanner sc = new Scanner(System.in);
//        String hexString = sc.nextLine();   //读取一个16进制的数字字符串
//Arrays.fill(arr,1);  给数组整体初始化为多少

        int[] arr = createArr();
        //System.out.println("排序前："+Arrays.toString(arr));
        long start = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        //System.out.println("排序后："+Arrays.toString(arr));
    }


    //堆排序
    public static void heapSort(int[] arr){
        createHeap(arr,arr.length);   //建立大顶堆
        //然后每次把大顶堆的头放到最后面去，然后最后面那个数就是有序的
        //然后每次数组长度都会变少一个，因为每次选最大的放到后面
        for(int i=0;i<arr.length-1;i++){    //趟数
            int maxVal = arr[0];    //取出最大的数
            //交换到最后面的位置去
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = maxVal;
            //然后0号下标,向下调整即可（但不包括有序区间)
            adjustDown(arr,arr.length-1-i,0);
        }
    }
    //建立大顶堆
    public static void createHeap(int[] arr,int size){
        int lastIndex = arr.length-1;
        int lastIndexParent = (lastIndex-1)/2;
        for(int i = lastIndexParent;i>=0;i--){
            adjustDown(arr,size,i);
        }
    }
    //向下调整
    public static void adjustDown(int[] arr,int size,int index){
        while (true){
            int leftIndex = index*2+1;
            if(leftIndex>=size){
                return; //表示当前index位置为叶子结点，不需要向下调整
            }
            int rightIndex = leftIndex+1;
            int maxIndex = leftIndex;
            if(rightIndex<size&&arr[rightIndex]>arr[leftIndex]){
                maxIndex = rightIndex;
            }
            //判断根节点val和孩子节点中最大的哪个大，建立大顶堆
            if(arr[index]>=arr[maxIndex]){
                break;  //说明目前该树已经满足大顶堆特性
            }
            int t = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = t;

            index = maxIndex;
        }
    }

    //插入排序
    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){  //把开始第一个看成一个有序的，
            int temp = arr[i];  //取出待插入元素
            int j;
            for(j=i-1;j>=0;j--){    //往前面有序的序列找位置
                if(arr[j]<=temp){
                    break;
                }else{
                    arr[j+1] = arr[j];  //后移
                }
            }
            arr[j+1] = temp;    //插入取出的元素
        }
    }
    //希尔排序
    public static void shellSort(int[] arr){
        int group = arr.length/2;   //也是把数组分成几组，同时也是步数
        while (group>0){    //当只分一组，排序完，就变成有序的了
            //给每一组进行插入排序
            for(int i=group;i<arr.length;i++){  //arr[i]每一组的第二个元素，往前插
                int temp = arr[i];  //待插入元素
                int j;
                for(j=i-group;j>=0;j-=group){   //找到待插入的位置,待插入位置就为下标为j+group的位置
                    if(arr[j]<=temp){   //找到待插入位置
                        break;
                    }else{  //如果前面的比待插入元素大，就后移
                        arr[j+group] = arr[j];
                    }
                }
                arr[j+group] = temp;
            }
            group/=2;   //要进行下一次分组，分的组更少一点
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){    //表示趟数
            boolean flag = true;
            for(int j=0;j<arr.length-1-i;j++){  //每一趟冒泡一个最大的数到数组尾部
                if(arr[j]>arr[j+1]){
                    arr[j]^=arr[j+1];
                    arr[j+1]^=arr[j];
                    arr[j]^=arr[j+1];
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = t;
        }
    }

}
